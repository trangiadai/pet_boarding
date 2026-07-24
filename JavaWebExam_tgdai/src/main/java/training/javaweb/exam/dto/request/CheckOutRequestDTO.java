package training.javaweb.exam.dto.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CheckOutRequestDTO {
	@NotNull(message = "The id of the boarding record can not be empty or invalid value")
	@Positive(message = "The id of boarding record must be > 0")
	@Schema(description = "The id of the boarding record", example = "10")
	private Long boardingRecordId;

	@NotNull(message = "The actual check out day can not be empty")
	@FutureOrPresent(message = "The actual check out day is invalid value, it must be after or equal to the current day")
	@Schema(description = "The expected check out day", example = "2026-08-23")
	private LocalDate actualCheckOut;

	@NotNull(message = "The daily fee of the boarding record can not be empty")
	@Positive(message = "The daily fee of boarding record must be > 0")
	@Schema(description = "The daily fee of the boarding record", example = "100000")
	private Long dailyFee;

	public CheckOutRequestDTO() {
		super();
	}

	public CheckOutRequestDTO(Long boardingRecordId, LocalDate actualCheckOut, Long dailyFee) {
		super();
		this.boardingRecordId = boardingRecordId;
		this.actualCheckOut = actualCheckOut;
		this.dailyFee = dailyFee;
	}

	public Long getBoardingRecordId() {
		return boardingRecordId;
	}

	public void setBoardingRecordId(Long boardingRecordId) {
		this.boardingRecordId = boardingRecordId;
	}

	public LocalDate getActualCheckOut() {
		return actualCheckOut;
	}

	public void setActualCheckOut(LocalDate actualCheckOut) {
		this.actualCheckOut = actualCheckOut;
	}

	public Long getDailyFee() {
		return dailyFee;
	}

	public void setDailyFee(Long dailyFee) {
		this.dailyFee = dailyFee;
	}

}