package training.javaweb.exam.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.javaweb.exam.dto.mapper.BoardingRecordMapperDTO;
import training.javaweb.exam.dto.request.BoardingRecordRequestDTO;
import training.javaweb.exam.dto.request.FilterRequestParam;
import training.javaweb.exam.dto.request.SearchRequestParam;
import training.javaweb.exam.dto.response.BoardingRecordResponseDTO;
import training.javaweb.exam.dto.response.MyActiveBoardingResponseDTO;
import training.javaweb.exam.entity.BoardingRecord;
import training.javaweb.exam.entity.Pet;
import training.javaweb.exam.enums.BoardingFee;
import training.javaweb.exam.enums.BoardingStatus;
import training.javaweb.exam.repository.BoardingRecordRepository;
import training.javaweb.exam.repository.PetRepository;

@Service
public class BoardingRecordService {

	private final BoardingRecordRepository boardingRecordRepository;
	private final PetRepository petRepository;

	@Transactional
	public BoardingRecordResponseDTO createRecord(BoardingRecordRequestDTO boardingRecordRequest, Long dailyFee) {
		Pet pet = petRepository.getPetById(boardingRecordRequest.getPetId());
		if (pet == null) {
			throw new IllegalArgumentException("Pet not found with ID: " + boardingRecordRequest.getPetId());
		}

		long expectedDays = ChronoUnit.DAYS.between(boardingRecordRequest.getCheckInDate(),
				boardingRecordRequest.getExpectedCheckOut());
		if (expectedDays <= 0) {
			expectedDays = 1;
		}

		long baseFee = expectedDays * dailyFee;
		long totalFee = applyDiscount(baseFee, expectedDays);

		BoardingRecord boardingRecord = BoardingRecordMapperDTO.toBoardingRecord(boardingRecordRequest);
		boardingRecord.setBaseFee(baseFee);
		boardingRecord.setLateFee(0L);
		boardingRecord.setTotalFee(totalFee);

		Long newId = boardingRecordRepository.createRecord(boardingRecord, dailyFee);
		return getRecordById(newId);
	}

	public List<BoardingRecordResponseDTO> getAllRecords() {
		return boardingRecordRepository.getAllRecords().stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

	// C3. Record Details
	public BoardingRecordResponseDTO getRecordById(Long id) {
		BoardingRecord boardingRecord = boardingRecordRepository.getRecordById(id);
		if (boardingRecord == null) {
			throw new IllegalArgumentException("Boarding record not found with ID: " + id);
		}
		return BoardingRecordMapperDTO.toBoardingRecordResponse(boardingRecord);
	}

//	TODO: fix this method in the next day (not complete yet)
//	@Transactional
//	public BoardingRecordResponseDTO checkOut(Long boardingRecordId, LocalDate actualCheckOut, Long dailyFee) {
//		BoardingRecord boardingRecord = boardingRecordRepository.getRecordById(boardingRecordId);
//		if (boardingRecord == null)
//			throw new IllegalArgumentException("Record not found.");
//		if (BoardingStatus.RETURNED.name().equalsIgnoreCase(boardingRecord.getStatus())) {
//			throw new IllegalStateException("Pet has already been returned.");
//		}
//
//		LocalDate checkIn = boardingRecord.getCheckInDate();
//		LocalDate expectedOut = boardingRecord.getExpectedCheckOut();
//
//		long expectedDays = ChronoUnit.DAYS.between(checkIn, expectedOut);
//		if (expectedDays <= 0)
//			expectedDays = 1;
//
//		long actualDays = ChronoUnit.DAYS.between(checkIn, actualCheckOut);
//		if (actualDays <= 0)
//			actualDays = 1;
//
//		long baseFee;
//		long lateFee = 0;
//
//		if (actualCheckOut.isAfter(expectedOut)) {
//			baseFee = actualDays * dailyFee;
//			long lateDays = ChronoUnit.DAYS.between(expectedOut, actualCheckOut);
//			lateFee = Math.round(lateDays * dailyFee * BoardingFee.OVERDUE_CHARGE_PERCENTAGE.getValue());
//		} else {
//			baseFee = expectedDays * dailyFee;
//		}
//
//		long totalBeforeDiscount = baseFee + lateFee;
//		long finalTotalFee = applyDiscount(totalBeforeDiscount, actualDays);
//
//		boardingRecordRepository.updateCheckOut(boardingRecordId, actualCheckOut, baseFee, lateFee, finalTotalFee);
//		return getRecordById(boardingRecordId);
//	}

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

	public List<BoardingRecordResponseDTO> searchByDateRange(SearchRequestParam searchRequestParam) {
		return boardingRecordRepository.searchByDateRange(searchRequestParam).stream().map(record -> {
			return BoardingRecordMapperDTO.toBoardingRecordResponse(record);
		}).collect(Collectors.toList());
	}

//	// TODO: by phone and check user name password again to know are they have permision to get that value
//	// C9 & Requirement 1: My Active Boarding
//	public List<MyActiveBoardingResponseDTO> getMyActiveBoarding(Long ownerId, Long dailyFee) {
//		List<BoardingRecord> activeRecords = boardingRecordRepository.getActiveRecordsByOwnerId(ownerId);
//		LocalDate today = LocalDate.now();
//
//		return activeRecords.stream().map(record -> {
//			MyActiveBoardingResponseDTO dto = new MyActiveBoardingResponseDTO();
//			dto.setRecord(BoardingRecordMapperDTO.toBoardingRecordResponse(record));
//
//			// Requirement 1.2: Days boarded so far
//			long daysSoFar = ChronoUnit.DAYS.between(record.getCheckInDate(), today);
//			if (daysSoFar <= 0)
//				daysSoFar = 1;
//
//			// Requirement 1.3: Days remaining until expected return
//			long daysRemaining = ChronoUnit.DAYS.between(today, record.getExpectedCheckOut());
//
//			// Requirement 1.1: Temporary estimated fee up to today
//			long estBaseFee;
//			long estLateFee = 0;
//
//			if (today.isAfter(record.getExpectedCheckOut())) {
//				estBaseFee = daysSoFar * dailyFee;
//				long lateDays = ChronoUnit.DAYS.between(record.getExpectedCheckOut(), today);
//				estLateFee = Math.round(lateDays * dailyFee * BoardingFee.OVERDUE_CHARGE_PERCENTAGE.getValue());
//			} else {
//				long expectedDays = ChronoUnit.DAYS.between(record.getCheckInDate(), record.getExpectedCheckOut());
//				if (expectedDays <= 0)
//					expectedDays = 1;
//				estBaseFee = expectedDays * dailyFee;
//			}
//
//			long estTotal = applyDiscount(estBaseFee + estLateFee, daysSoFar);
//
//			dto.setDaysBoardedSoFar(daysSoFar);
//			dto.setDaysRemaining(daysRemaining);
//			dto.setEstimatedFee(estTotal);
//
//			return dto;
//		}).collect(Collectors.toList());
//	}

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

	private long applyDiscount(long fee, long durationDays) {
		double discount = 0.0;
		if (durationDays >= 14) {
			discount = 0.10;
		} else if (durationDays >= 7) {
			discount = 0.05;
		}
		return fee - (long) (fee * discount);
	}

	public BoardingRecordService(BoardingRecordRepository boardingRecordRepository, PetRepository petRepository) {
		super();
		this.boardingRecordRepository = boardingRecordRepository;
		this.petRepository = petRepository;
	}

}