package training.javaweb.exam.dto.mapper;

import java.util.stream.Collectors;

import training.javaweb.exam.dto.request.BoardingRecordRequestDTO;
import training.javaweb.exam.dto.response.BoardingRecordResponseDTO;
import training.javaweb.exam.entity.BoardingRecord;
import training.javaweb.exam.enums.BoardingStatus;

public class BoardingRecordMapperDTO {
	public static BoardingRecordResponseDTO toBoardingRecordResponse(BoardingRecord boardingRecord) {
		BoardingRecordResponseDTO boardingRecordResponse = new BoardingRecordResponseDTO();
		boardingRecordResponse.setId(boardingRecord.getId());
		boardingRecordResponse.setPetId(boardingRecord.getPetId());
		boardingRecordResponse.setCheckInDate(boardingRecord.getCheckInDate());
		boardingRecordResponse.setExpectedCheckOut(boardingRecord.getExpectedCheckOut());
		boardingRecordResponse.setActualCheckOut(boardingRecord.getActualCheckOut());
		boardingRecordResponse.setBaseFee(boardingRecord.getBaseFee());
		boardingRecordResponse.setLateFee(boardingRecord.getLateFee());
		boardingRecordResponse.setTotalFee(boardingRecord.getTotalFee());
		boardingRecordResponse.setStatus(BoardingStatus.valueOf(boardingRecord.getStatus().trim().toUpperCase()));
		boardingRecordResponse.setNotes(boardingRecord.getNotes());
		boardingRecordResponse.setCreatedAt(boardingRecord.getCreatedAt());

		boardingRecordResponse.setPetResponse(PetMapperDTO.toPetResponse(boardingRecord.getPet()));
		if (boardingRecord.getCareNotes() != null && !boardingRecord.getCareNotes().isEmpty()) {
			boardingRecordResponse.setCareNoteResponses(boardingRecord.getCareNotes().stream().map(careNote -> {
				return CareNoteMapperDTO.toCareNoteResponse(careNote);
			}).collect(Collectors.toList()));
		}

		return boardingRecordResponse;
	}

	public static BoardingRecord toBoardingRecord(BoardingRecordRequestDTO boardingRecordRequest) {
		BoardingRecord boardingRecord = new BoardingRecord();
		boardingRecord.setPetId(boardingRecordRequest.getPetId());
		boardingRecord.setCheckInDate(boardingRecordRequest.getCheckInDate());
		boardingRecord.setExpectedCheckOut(boardingRecordRequest.getExpectedCheckOut());
		boardingRecord.setStatus(boardingRecordRequest.getStatus().name());
		boardingRecord.setNotes(boardingRecordRequest.getNotes());
		boardingRecord.setCreatedAt(boardingRecordRequest.getCreatedAt());

		return boardingRecord;
	}
}
