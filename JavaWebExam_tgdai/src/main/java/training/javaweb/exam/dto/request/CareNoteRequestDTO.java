package training.javaweb.exam.dto.request;

import java.time.LocalDateTime;

public class CareNoteRequestDTO {
	private Long boardingRecordId;
	private String note;
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