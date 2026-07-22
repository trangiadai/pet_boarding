package training.javaweb.exam.dto.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public class CareNoteResponseDTO {
	@Schema(description = "The note content", example = "This is note content")
	private String note;
	@Schema(description = "The formal entry date of batch into system logs", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;

	public CareNoteResponseDTO(String note, LocalDateTime createdAt) {
		super();
		this.note = note;
		this.createdAt = createdAt;
	}

	public CareNoteResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
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

}
