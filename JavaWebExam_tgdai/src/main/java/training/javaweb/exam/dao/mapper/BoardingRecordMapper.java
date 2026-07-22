package training.javaweb.exam.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import training.javaweb.exam.entity.BoardingRecord;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardingRecordMapper {
	void createRecord(Map<String, Object> param);

	List<BoardingRecord> getAllRecords();

	BoardingRecord getRecordById(Map<String, Object> param);

//	void updateCheckOut(Map<String, Object> param);

	List<BoardingRecord> getActiveBoardingRecords();

	List<BoardingRecord> getRecordsByPetId(Map<String, Object> param);

	List<BoardingRecord> getRecordsByOwnerId(Map<String, Object> param);

	List<BoardingRecord> searchByDateRange(Map<String, Object> param);
//	TODO: this method isn't finish yet (waiting for adding security)
//	List<BoardingRecord> getActiveRecordsByOwnerId(Map<String, Object> param);

	List<BoardingRecord> filterBoardingRecords(Map<String, Object> param);
}