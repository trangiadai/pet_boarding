package training.javaweb.exam.entity;

import java.time.LocalDateTime;

public class CareNote {
	private Long id;
	private Long boardingRecordId;
	private String note;
	private LocalDateTime createdAt;

	public CareNote(Long id, Long boardingRecordId, String note, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.boardingRecordId = boardingRecordId;
		this.note = note;
		this.createdAt = createdAt;
	}

	public CareNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}