package training.javaweb.exam.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class MyActiveBoardingResponseDTO {
	@Schema(description = "Boarding record detailed information")
	private BoardingRecordResponseDTO record;

	@Schema(description = "Requirement week 2; 1.1: Temporary estimated total fee up to today", example = "350000")
	private Long estimatedFee;

	@Schema(description = "Requirement week 2; 1.2: Days boarded from check-in up to today", example = "5")
	private long daysBoardedSoFar;

	@Schema(description = "Requirement week 2; 1.3: Days remaining until expected check-out date", example = "3")
	private long daysRemaining;

	public BoardingRecordResponseDTO getRecord() {
		return record;
	}

	public void setRecord(BoardingRecordResponseDTO record) {
		this.record = record;
	}

	public Long getEstimatedFee() {
		return estimatedFee;
	}

	public void setEstimatedFee(Long estimatedFee) {
		this.estimatedFee = estimatedFee;
	}

	public long getDaysBoardedSoFar() {
		return daysBoardedSoFar;
	}

	public void setDaysBoardedSoFar(long daysBoardedSoFar) {
		this.daysBoardedSoFar = daysBoardedSoFar;
	}

	public long getDaysRemaining() {
		return daysRemaining;
	}

	public void setDaysRemaining(long daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	public MyActiveBoardingResponseDTO(BoardingRecordResponseDTO record, Long estimatedFee, long daysBoardedSoFar,
			long daysRemaining) {
		super();
		this.record = record;
		this.estimatedFee = estimatedFee;
		this.daysBoardedSoFar = daysBoardedSoFar;
		this.daysRemaining = daysRemaining;
	}

	public MyActiveBoardingResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}