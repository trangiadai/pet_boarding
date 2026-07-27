package training.javaweb.exam.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dto.mapper.BoardingRecordMapperDTO;
import training.javaweb.exam.dto.request.BoardingRecordRequestDTO;
import training.javaweb.exam.dto.request.CheckOutRequestDTO;
import training.javaweb.exam.dto.request.FilterRequestParam;
import training.javaweb.exam.dto.request.SearchRequestParam;
import training.javaweb.exam.dto.response.BoardingRecordResponseDTO;
import training.javaweb.exam.dto.response.FeeResult;
import training.javaweb.exam.dto.response.MyActiveBoardingResponseDTO;
import training.javaweb.exam.dto.response.PetResponseDTO;
import training.javaweb.exam.entity.BoardingRecord;
import training.javaweb.exam.enums.BoardingStatus;
import training.javaweb.exam.repository.BoardingRecordRepository;
import training.javaweb.exam.security.CustomUserDetails;
import training.javaweb.exam.utils.FeeCalculator;

@Service
public class BoardingRecordService {
	private final BoardingRecordRepository boardingRecordRepository;
	private final PetService petService;

	@Transactional
	public BoardingRecordResponseDTO createRecord(BoardingRecordRequestDTO request) {
		PetResponseDTO petResponse = petService.getPetById(request.getPetId());
		if (petResponse == null) {
			throw new IllegalArgumentException("Pet not found with ID: " + request.getPetId());
		}
		if (boardingRecordRepository.getActiveBoardingRecordsByPetId(request.getPetId()) != null) {
			throw new IllegalArgumentException("This pet is already BOARDING, can't create another boarding record");
		}

		BoardingRecord record = BoardingRecordMapperDTO.toBoardingRecord(request);

		LocalDate checkInDate = LocalDate.now();
		long expectedDays = request.getExpectedNumberOfDayService();
		LocalDate expectedCheckOut = checkInDate.plusDays(expectedDays);

		record.setCheckInDate(checkInDate);
		record.setExpectedCheckOut(expectedCheckOut);

		long initialBaseFee = expectedDays * request.getDailyFee();
		record.setBaseFee(initialBaseFee);
		record.setLateFee(0L);
		record.setDiscount(0L);
		record.setTotalFee(initialBaseFee);

		Long newId = boardingRecordRepository.createRecord(record);
		return getRecordById(newId);
	}

	public List<BoardingRecordResponseDTO> getAllRecords() {
		return boardingRecordRepository.getAllRecords().stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	public BoardingRecordResponseDTO getRecordById(Long id) {
		BoardingRecord boardingRecord = boardingRecordRepository.getRecordById(id);
		if (boardingRecord == null) {
			throw new IllegalArgumentException("Boarding record not found with ID: " + id);
		}
		return BoardingRecordMapperDTO.toBoardingRecordResponse(boardingRecord);
	}

	@Transactional
	public BoardingRecordResponseDTO checkOut(CheckOutRequestDTO request) {
		BoardingRecord record = boardingRecordRepository.getRecordById(request.getBoardingRecordId());
		if (record == null) {
			throw new IllegalArgumentException("Record not found.");
		}
		if (BoardingStatus.RETURNED.name().equalsIgnoreCase(record.getStatus())) {
			throw new IllegalStateException("Pet has already been returned.");
		}

		LocalDate actualCheckOut = LocalDate.now();
		long dailyFee = (request.getDailyFee() != null) ? request.getDailyFee() : record.getDailyFee();
		FeeResult result = FeeCalculator.calculateCheckOutFee(record.getCheckInDate(), record.getExpectedCheckOut(),
				actualCheckOut, dailyFee);

		boardingRecordRepository.checkOut(request.getBoardingRecordId(), actualCheckOut, result.baseFee, result.lateFee,
				result.discountAmount, result.totalFee, BoardingStatus.RETURNED.name());

		return getRecordById(request.getBoardingRecordId());
	}

	public List<BoardingRecordResponseDTO> getActiveBoardingRecords() {
		return boardingRecordRepository.getActiveBoardingRecords().stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	public List<BoardingRecordResponseDTO> getRecordsByPetId(Long petId) {
		return boardingRecordRepository.getRecordsByPetId(petId).stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	public List<BoardingRecordResponseDTO> getRecordsByOwnerId(Long ownerId) {
		return boardingRecordRepository.getRecordsByOwnerId(ownerId).stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	public List<BoardingRecordResponseDTO> getRecordsByOwnerId(CustomUserDetails userDetails) {
		Long ownerId = userDetails.getOwnerId();

		return boardingRecordRepository.getRecordsByOwnerId(ownerId).stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	public List<BoardingRecordResponseDTO> searchByDateRange(SearchRequestParam searchRequestParam) {
		return boardingRecordRepository.searchByDateRange(searchRequestParam).stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	public List<MyActiveBoardingResponseDTO> getMyActiveBoardingRecords(CustomUserDetails userDetails) {
		Long ownerId = userDetails.getOwnerId();
		List<BoardingRecord> records = boardingRecordRepository.getMyActiveBoardingRecords(ownerId);
		LocalDate today = LocalDate.now();

		return records.stream().map(record -> {
			BoardingRecordResponseDTO recordDTO = BoardingRecordMapperDTO.toBoardingRecordResponse(record);

			LocalDate checkIn = record.getCheckInDate();
			LocalDate expectedOut = record.getExpectedCheckOut();

			long daysBoardedSoFar = ChronoUnit.DAYS.between(checkIn, today);
			if (daysBoardedSoFar < 0)
				daysBoardedSoFar = 0;

			long daysRemaining = ChronoUnit.DAYS.between(today, expectedOut);
			if (daysRemaining < 0) {
				daysRemaining = 0;
			}

			long dailyFee = (record.getDailyFee() != null) ? record.getDailyFee() : 0L;
			FeeResult estimatedResult = FeeCalculator.calculateOngoingFee(checkIn, expectedOut, today, dailyFee);

			MyActiveBoardingResponseDTO dto = new MyActiveBoardingResponseDTO();
			dto.setRecord(recordDTO);
			dto.setDaysBoardedSoFar(daysBoardedSoFar);
			dto.setDaysRemaining(daysRemaining);
			dto.setEstimatedFee(estimatedResult.totalFee);

			return dto;
		}).collect(Collectors.toList());
	}

	public List<BoardingRecordResponseDTO> filterBoardingRecords(FilterRequestParam filterRequestParam) {
		String boardingRecordStatus = null;
		String petType = null;
		if (filterRequestParam.getBoardingRecordStatus() != null) {
			boardingRecordStatus = filterRequestParam.getBoardingRecordStatus().name();
		}
		if (filterRequestParam.getPetType() != null) {
			petType = filterRequestParam.getPetType().name();
		}

		return boardingRecordRepository.filterBoardingRecords(boardingRecordStatus, petType,
				filterRequestParam.getOwnerId(), filterRequestParam.getFromDate(), filterRequestParam.getToDate())
				.stream().map(record -> {
					return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
				}).collect(Collectors.toList());
	}

	public BoardingRecordService(BoardingRecordRepository boardingRecordRepository, PetService petService) {
		super();
		this.boardingRecordRepository = boardingRecordRepository;
		this.petService = petService;
	}

}