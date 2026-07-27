package training.javaweb.exam.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CareNoteRequestDTO {
	@NotNull(message = "CareNoteRequest's boardingRecordId can not be empty or invalid value")
	@Positive(message = "CareNoteRequest's boardingRecordId must be > 0")
	@Schema(description = "The id of boarding record", example = "11")
	private Long boardingRecordId;

	@NotBlank(message = "Note content can not be empty or just a space/tab")
	@Schema(description = "The note content", example = "This is note content")
	private String note;

	public Long getBoardingRecordId() {
		return boardingRecordId;
	}

	public void setBoardingRecordId(Long boardingRecordId) {
		this.boardingRecordId = boardingRecordId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public CareNoteRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CareNoteRequestDTO(Long boardingRecordId, String note, LocalDateTime createdAt) {
		super();
		this.boardingRecordId = boardingRecordId;
		this.note = note;
	}

}