package training.javaweb.exam.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import training.javaweb.exam.entity.BoardingRecord;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardingRecordMapper {
	void createRecord(Map<String, Object> param);

	BoardingRecord getActiveBoardingRecordsByPetId(Map<String, Object> param);

	List<BoardingRecord> getAllRecords();

	BoardingRecord getRecordById(Map<String, Object> param);

	void checkOut(Map<String, Object> param);

	List<BoardingRecord> getActiveBoardingRecords();

	List<BoardingRecord> getRecordsByPetId(Map<String, Object> param);

	List<BoardingRecord> getRecordsByOwnerId(Map<String, Object> param);

	List<BoardingRecord> searchByDateRange(Map<String, Object> param);

	List<BoardingRecord> getMyActiveBoardingRecords(Map<String, Object> param);

	List<BoardingRecord> filterBoardingRecords(Map<String, Object> param);

	Long findOwnerIdByBoardingRecordId(Map<String, Object> param);
}