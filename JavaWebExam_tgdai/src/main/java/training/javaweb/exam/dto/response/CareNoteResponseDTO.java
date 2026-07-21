package training.javaweb.exam.dto.response;

import java.time.LocalDateTime;

public class CareNoteResponseDTO {
	private String note;
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
