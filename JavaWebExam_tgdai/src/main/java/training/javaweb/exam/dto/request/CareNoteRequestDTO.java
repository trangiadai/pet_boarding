package training.javaweb.exam.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class CareNoteRequestDTO {
	@NotNull(message = "Boarding record id can not be empty or invalid value")
	@Positive(message = "Boarding record id must be > 0")
	@Schema(description = "The id of boarding record", example = "11")
	private Long boardingRecordId;
	
	@NotBlank(message = "Note content can not be empty or just a space/tab")
	@Schema(description = "The note content", example = "This is note content")
	private String note;
	
	@NotNull(message = "CareNoteRequest's createdAt can not be empty")
	@PastOrPresent(message = "Input time is invalid value, it must be before current time")
	@Schema(description = "The formal entry date of batch into system logs", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public CareNoteRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CareNoteRequestDTO(Long boardingRecordId, String note, LocalDateTime createdAt) {
		super();
		this.boardingRecordId = boardingRecordId;
		this.note = note;
		this.createdAt = createdAt;
	}

}