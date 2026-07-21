package training.javaweb.exam.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import training.javaweb.exam.enums.BoardingStatus;

public class BoardingRecordRequestDTO {
	private Long petId;
	private LocalDate checkInDate;
	private LocalDate expectedCheckOut;
	private BoardingStatus status;
	private String notes;
	private LocalDateTime createdAt;

	public BoardingRecordRequestDTO(Long petId, LocalDate checkInDate, LocalDate expectedCheckOut,
			BoardingStatus status, String notes, LocalDateTime createdAt) {
		super();
		this.petId = petId;
		this.checkInDate = checkInDate;
		this.expectedCheckOut = expectedCheckOut;
		this.status = status;
		this.notes = notes;
		this.createdAt = createdAt;
	}

	public BoardingRecordRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getExpectedCheckOut() {
		return expectedCheckOut;
	}

	public void setExpectedCheckOut(LocalDate expectedCheckOut) {
		this.expectedCheckOut = expectedCheckOut;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public BoardingStatus getStatus() {
		return status;
	}

	public void setStatus(BoardingStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}