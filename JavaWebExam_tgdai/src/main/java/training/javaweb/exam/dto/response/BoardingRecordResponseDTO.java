package training.javaweb.exam.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import training.javaweb.exam.enums.BoardingStatus;

public class BoardingRecordResponseDTO {
	private Long id;
	private Long petId;
	private LocalDate checkInDate;
	private LocalDate expectedCheckOut;
	private LocalDate actualCheckOut;
	private Long baseFee;
	private Long lateFee;
	private Long totalFee;
	private BoardingStatus status;
	private String notes;
	private LocalDateTime createdAt;
	private PetResponseDTO petResponse;
	private List<CareNoteResponseDTO> careNoteResponses;

	public BoardingRecordResponseDTO(Long id, Long petId, LocalDate checkInDate, LocalDate expectedCheckOut,
			LocalDate actualCheckOut, Long baseFee, Long lateFee, Long totalFee, BoardingStatus status, String notes,
			LocalDateTime createdAt, PetResponseDTO petResponse, List<CareNoteResponseDTO> careNoteResponses) {
		super();
		this.id = id;
		this.petId = petId;
		this.checkInDate = checkInDate;
		this.expectedCheckOut = expectedCheckOut;
		this.actualCheckOut = actualCheckOut;
		this.baseFee = baseFee;
		this.lateFee = lateFee;
		this.totalFee = totalFee;
		this.status = status;
		this.notes = notes;
		this.createdAt = createdAt;
		this.petResponse = petResponse;
		this.careNoteResponses = careNoteResponses;
	}

	public BoardingRecordResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getActualCheckOut() {
		return actualCheckOut;
	}

	public void setActualCheckOut(LocalDate actualCheckOut) {
		this.actualCheckOut = actualCheckOut;
	}

	public Long getBaseFee() {
		return baseFee;
	}

	public void setBaseFee(Long baseFee) {
		this.baseFee = baseFee;
	}

	public Long getLateFee() {
		return lateFee;
	}

	public void setLateFee(Long lateFee) {
		this.lateFee = lateFee;
	}

	public Long getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}

	public BoardingStatus getStatus() {
		return status;
	}

	public void setStatus(BoardingStatus status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public PetResponseDTO getPetResponse() {
		return petResponse;
	}

	public void setPetResponse(PetResponseDTO petResponse) {
		this.petResponse = petResponse;
	}

	public List<CareNoteResponseDTO> getCareNoteResponses() {
		return careNoteResponses;
	}

	public void setCareNoteResponses(List<CareNoteResponseDTO> careNoteResponses) {
		this.careNoteResponses = careNoteResponses;
	}
}