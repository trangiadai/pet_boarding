package training.javaweb.exam.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.BoardingRecordMapper;
import training.javaweb.exam.dto.request.SearchRequestParam;
import training.javaweb.exam.entity.BoardingRecord;

@Repository
public class BoardingRecordRepository {
	private final BoardingRecordMapper boardingRecordMapper;

	public Long createRecord(BoardingRecord boardingRecord) {
		Map<String, Object> param = new HashMap<>();
		param.put("petId", boardingRecord.getPetId());
		param.put("checkInDate", boardingRecord.getCheckInDate());
		param.put("expectedCheckOut", boardingRecord.getExpectedCheckOut());
		param.put("dailyFee", boardingRecord.getDailyFee());
		param.put("baseFee", boardingRecord.getBaseFee());
		param.put("lateFee", boardingRecord.getLateFee());
		param.put("discount", boardingRecord.getDiscount());
		param.put("totalFee", boardingRecord.getTotalFee());
		param.put("status", boardingRecord.getStatus());
		param.put("notes", boardingRecord.getNotes());
		param.put("createdAt", boardingRecord.getCreatedAt());

		boardingRecordMapper.createRecord(param);
		return ((Number) param.get("id")).longValue();
	}

	public BoardingRecord getActiveBoardingRecordsByPetId(Long petId) {
		Map<String, Object> param = new HashMap<>();
		param.put("petId", petId);

		return boardingRecordMapper.getActiveBoardingRecordsByPetId(param);
	}

	public List<BoardingRecord> getAllRecords() {
		return boardingRecordMapper.getAllRecords();
	}

	public BoardingRecord getRecordById(Long id) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);

		return boardingRecordMapper.getRecordById(param);
	}

	public void checkOut(Long id, LocalDate actualCheckOut, Long baseFee, Long lateFee, Long discount, Long totalFee,
			String recordStatus) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("actualCheckOut", actualCheckOut);
		param.put("baseFee", baseFee);
		param.put("lateFee", lateFee);
		param.put("discount", discount);
		param.put("totalFee", totalFee);
		param.put("recordStatus", recordStatus);
		boardingRecordMapper.checkOut(param);
	}

	public List<BoardingRecord> getActiveBoardingRecords() {
		return boardingRecordMapper.getActiveBoardingRecords();
	}

	public List<BoardingRecord> getRecordsByPetId(Long petId) {
		Map<String, Object> param = new HashMap<>();
		param.put("petId", petId);

		return boardingRecordMapper.getRecordsByPetId(param);
	}

	public List<BoardingRecord> getRecordsByOwnerId(Long ownerId) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerId", ownerId);

		return boardingRecordMapper.getRecordsByOwnerId(param);
	}

	public List<BoardingRecord> searchByDateRange(SearchRequestParam searchRequestParam) {
		Map<String, Object> param = new HashMap<>();
		param.put("fromDate", searchRequestParam.getFromDate());
		param.put("toDate", searchRequestParam.getToDate());

		return boardingRecordMapper.searchByDateRange(param);
	}

	public List<BoardingRecord> getMyActiveBoardingRecords(Long ownerId) {
		Map<String, Object> param = new HashMap<>();
		param.put("ownerId", ownerId);

		return boardingRecordMapper.getMyActiveBoardingRecords(param);
	}

	public List<BoardingRecord> filterBoardingRecords(String boardingRecordstatus, String petType, Long ownerId,
			LocalDate fromDate, LocalDate toDate) {
		Map<String, Object> param = new HashMap<>();
		param.put("status", boardingRecordstatus);
		param.put("type", petType);
		param.put("ownerId", ownerId);
		param.put("fromDate", fromDate);
		param.put("toDate", toDate);

		return boardingRecordMapper.filterBoardingRecords(param);
	}

	public Long findOwnerIdByBoardingRecordId(Long boardingRecordId) {
		Map<String, Object> param = new HashMap<>();
		param.put("recordId", boardingRecordId);

		return boardingRecordMapper.findOwnerIdByBoardingRecordId(param);
	}

	public BoardingRecordRepository(BoardingRecordMapper boardingRecordMapper) {
		super();
		this.boardingRecordMapper = boardingRecordMapper;
	}

}