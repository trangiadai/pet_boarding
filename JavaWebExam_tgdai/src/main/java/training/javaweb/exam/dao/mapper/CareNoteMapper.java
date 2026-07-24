package training.javaweb.exam.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import training.javaweb.exam.entity.CareNote;

import java.util.List;
import java.util.Map;

@Mapper
public interface CareNoteMapper {
	void createCareNote(Map<String, Object> param);

	List<CareNote> getCareNotesByBoardingRecordId(Map<String, Object> param);

	Long getOwnerIdByBoardingRecordId(Map<String, Object> param);
}