package training.javaweb.exam.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import training.javaweb.exam.enums.BoardingStatus;

public class BoardingRecordResponseDTO {
	@Schema(description = "The id of the boarding record", example = "11")
	private Long id;
	@Schema(description = "The id of the pet", example = "11")
	private Long petId;
	@Schema(description = "The check in date", example = "2026-07-13")
	private LocalDate checkInDate;
	@Schema(description = "The expected check out day", example = "2026-08-23")
	private LocalDate expectedCheckOut;
	@Schema(description = "The actual check out day", example = "2026-08-23")
	private LocalDate actualCheckOut;
	@Schema(description = "The base fee of this boarding record", example = "100000")
	private Long baseFee;
	@Schema(description = "The late fee of this boarding record", example = "20000")
	private Long lateFee;
	@Schema(description = "The total fee of this boarding record", example = "120000")
	private Long totalFee;
	@Schema(description = "The type of boarding status", example = "BOARDING")
	private BoardingStatus status;
	@Schema(description = "The note of boarding record", example = "This is note")
	private String notes;
	@Schema(description = "The formal entry date of batch into system logs", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;
	@Schema(description = "The pet's information in this boarding record")
	private PetResponseDTO petResponse;
	@Schema(description = "The care notes of this boarding record")
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