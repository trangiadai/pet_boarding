package training.javaweb.exam.dto.request;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CheckOutRequestDTO {
	@NotNull(message = "The id of the boarding record can not be empty or invalid value")
	@Positive(message = "The id of boarding record must be > 0")
	@Schema(description = "The id of the boarding record", example = "10")
	private Long boardingRecordId;

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
		this.dailyFee = dailyFee;
	}

	public Long getBoardingRecordId() {
		return boardingRecordId;
	}

	public void setBoardingRecordId(Long boardingRecordId) {
		this.boardingRecordId = boardingRecordId;
	}

	public Long getDailyFee() {
		return dailyFee;
	}

	public void setDailyFee(Long dailyFee) {
		this.dailyFee = dailyFee;
	}

}