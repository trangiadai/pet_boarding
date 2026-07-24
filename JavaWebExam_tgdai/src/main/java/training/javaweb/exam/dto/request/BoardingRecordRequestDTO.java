package training.javaweb.exam.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import training.javaweb.exam.enums.BoardingStatus;

public class BoardingRecordRequestDTO {
	@NotNull(message = "Pet's id can not be empty or invalid value")
	@Positive(message = "Pet's id must be > 0")
	@Schema(description = "The id of the pet", example = "11")
	private Long petId;

	@NotNull(message = "The check in day can not be empty")
	@FutureOrPresent(message = "Input time is invalid value, it must be after current time")
	@Schema(description = "The check in date", example = "2026-07-30")
	private LocalDate checkInDate;

	@NotNull(message = "The expected check out time can not be empty")
	@FutureOrPresent(message = "The expected check out time is invalid value, it must be after or equal to the check in day")
	@Schema(description = "The expected check out day", example = "2026-08-23")
	private LocalDate expectedCheckOut;

	@NotNull(message = "The daily fee of the boarding record cannot be empty")
	@Positive(message = "The daily fee must be greater than 0")
	@Schema(description = "The daily fee per day", example = "100000")
	private Long dailyFee;

	@NotNull(message = "The boarding status can't be empty or invalid value")
	@Schema(description = "The type of boarding status", example = "BOARDING")
	private BoardingStatus status;

	@Schema(description = "The note of boarding record", example = "This is note")
	private String notes;

	@NotNull(message = "BoardingRecordRequest's createdAt can not be empty")
	@FutureOrPresent(message = "Input time is invalid value, it must be current time")
	@Schema(description = "The formal entry date of batch into system logs", example = "2026-07-13T09:47:48")
	private LocalDateTime createdAt;

	@JsonIgnore
	@AssertTrue(message = "The expected check out date must be after or equal to the check in day")
	public boolean isDateRangeValid() {
		if (checkInDate != null && expectedCheckOut != null) {
			return !expectedCheckOut.isBefore(checkInDate);
		}
		return true;
	}

	public BoardingRecordRequestDTO(Long petId, LocalDate checkInDate, LocalDate expectedCheckOut, Long dailyFee,
			BoardingStatus status, String notes, LocalDateTime createdAt) {
		super();
		this.petId = petId;
		this.checkInDate = checkInDate;
		this.expectedCheckOut = expectedCheckOut;
		this.dailyFee = dailyFee;
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

	public Long getDailyFee() {
		return dailyFee;
	}

	public void setDailyFee(Long dailyFee) {
		this.dailyFee = dailyFee;
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