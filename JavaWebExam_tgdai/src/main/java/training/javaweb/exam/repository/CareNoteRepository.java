package training.javaweb.exam.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import training.javaweb.exam.dao.mapper.CareNoteMapper;
import training.javaweb.exam.entity.CareNote;

@Repository
public class CareNoteRepository {
	private final CareNoteMapper careNoteMapper;

	public Long createCareNote(CareNote careNote) {
		Map<String, Object> param = new HashMap<>();
		param.put("boardingRecordId", careNote.getBoardingRecordId());
		param.put("note", careNote.getNote());
		careNoteMapper.createCareNote(param);

		return ((Number) param.get("id")).longValue();
	}

	public List<CareNote> getCareNotesByBoardingRecordId(Long boardingRecordId) {
		Map<String, Object> param = new HashMap<>();
		param.put("boardingRecordId", boardingRecordId);
		return careNoteMapper.getCareNotesByBoardingRecordId(param);
	}
	
	public CareNoteRepository(CareNoteMapper careNoteMapper) {
		this.careNoteMapper = careNoteMapper;
	}

}