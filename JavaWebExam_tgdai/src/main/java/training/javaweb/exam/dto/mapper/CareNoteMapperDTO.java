package training.javaweb.exam.dto.mapper;

import training.javaweb.exam.dto.request.CareNoteRequestDTO;
import training.javaweb.exam.dto.response.CareNoteResponseDTO;
import training.javaweb.exam.entity.CareNote;

public class CareNoteMapperDTO {

	public static CareNote toCareNote(CareNoteRequestDTO careNoteRequest) {
		CareNote careNote = new CareNote();
		careNote.setBoardingRecordId(careNoteRequest.getBoardingRecordId());
		careNote.setNote(careNoteRequest.getNote());

		return careNote;
	}

	public static CareNoteResponseDTO toCareNoteResponse(CareNote careNote) {
		CareNoteResponseDTO careNoteResponse = new CareNoteResponseDTO();
		careNoteResponse.setNote(careNote.getNote());
		careNoteResponse.setCreatedAt(careNote.getCreatedAt());

		return careNoteResponse;
	}
}