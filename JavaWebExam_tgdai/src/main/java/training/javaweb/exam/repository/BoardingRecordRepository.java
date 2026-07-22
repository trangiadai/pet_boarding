package training.javaweb.exam.repository;

import org.springframework.stereotype.Repository;
import training.javaweb.exam.dao.mapper.BoardingRecordMapper;
import training.javaweb.exam.dto.request.FilterRequestParam;
import training.javaweb.exam.dto.request.SearchRequestParam;
import training.javaweb.exam.entity.BoardingRecord;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardingRecordRepository {

	private final BoardingRecordMapper boardingRecordMapper;

	public Long createRecord(BoardingRecord boardingRecord, Long dailyFee) {
		Map<String, Object> param = new HashMap<>();
		param.put("petId", boardingRecord.getPetId());
		param.put("checkInDate", boardingRecord.getCheckInDate());
		param.put("expectedCheckOut", boardingRecord.getExpectedCheckOut());
		param.put("baseFee", boardingRecord.getBaseFee());
		param.put("lateFee", boardingRecord.getLateFee());
		param.put("totalFee", boardingRecord.getTotalFee());
		param.put("status", boardingRecord.getStatus());
		param.put("notes", boardingRecord.getNotes());
		param.put("createdAt", boardingRecord.getCreatedAt());
		boardingRecordMapper.createRecord(param);

		return ((Number) param.get("id")).longValue();
	}

	public List<BoardingRecord> getAllRecords() {
		return boardingRecordMapper.getAllRecords();
	}

	public BoardingRecord getRecordById(Long id) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);

		return boardingRecordMapper.getRecordById(param);
	}

//	TODO: fix this method in the next day (not complete yet)
//	public void updateCheckOut(Long id, LocalDate actualCheckOut, Long baseFee, Long lateFee, Long totalFee) {
//		Map<String, Object> param = new HashMap<>();
//		param.put("id", id);
//		param.put("actualCheckOut", actualCheckOut);
//		param.put("baseFee", baseFee);
//		param.put("lateFee", lateFee);
//		param.put("totalFee", totalFee);
//		boardingRecordMapper.updateCheckOut(param);
//	}

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

//	TODO: this method isn't finish yet (waiting for adding security)
//	public List<BoardingRecord> getActiveRecordsByOwnerId(Long ownerId) {
//		Map<String, Object> param = new HashMap<>();
//		param.put("ownerId", ownerId);
//		
//		return boardingRecordMapper.getActiveRecordsByOwnerId(param);
//	}

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

	public BoardingRecordRepository(BoardingRecordMapper boardingRecordMapper) {
		super();
		this.boardingRecordMapper = boardingRecordMapper;
	}

}