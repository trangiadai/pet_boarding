package training.javaweb.exam.dto.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import training.javaweb.exam.enums.BoardingStatus;

public class BoardingRecordRequestDTO {
	@NotNull(message = "Pet's id can not be empty or invalid value")
	@Positive(message = "Pet's id must be > 0")
	@Schema(description = "The id of the pet", example = "11")
	private Long petId;

	@NotNull(message = "The expected number of day for using the service")
	@Positive(message = "The number of day must be > 0")
	@Max(value = 3652, message = "The maximum number of day is 3652 days (10 years)")
	@Schema(description = "The expected number of day for using the service", example = "2")
	private Long expectedNumberOfDayService;

	@NotNull(message = "The daily fee of the boarding record cannot be empty")
	@Positive(message = "The daily fee must be greater than 0")
	@Schema(description = "The daily fee per day", example = "100000")
	private Long dailyFee;

	@NotNull(message = "The boarding status can't be empty or invalid value")
	@Schema(description = "The type of boarding status", example = "BOARDING")
	private BoardingStatus status;

	@Schema(description = "The note of boarding record", example = "This is note")
	private String notes;

	public BoardingRecordRequestDTO(Long petId, Long expectedNumberOfDayService, Long dailyFee, BoardingStatus status,
			String notes, LocalDateTime createdAt) {
		super();
		this.petId = petId;
		this.expectedNumberOfDayService = expectedNumberOfDayService;
		this.dailyFee = dailyFee;
		this.status = status;
		this.notes = notes;
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

	public Long getExpectedNumberOfDayService() {
		return expectedNumberOfDayService;
	}

	public void setExpectedNumberOfDayService(Long expectedNumberOfDayService) {
		this.expectedNumberOfDayService = expectedNumberOfDayService;
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

}