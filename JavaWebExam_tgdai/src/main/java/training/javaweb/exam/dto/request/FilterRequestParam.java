package training.javaweb.exam.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Positive;
import training.javaweb.exam.enums.BoardingStatus;
import training.javaweb.exam.enums.PetType;

public class FilterRequestParam {
	@Schema(description = "The type of boarding status", example = "BOARDING")
	private BoardingStatus boardingRecordStatus;

	@Schema(description = "The type of pet", example = "CAT")
	private PetType petType;

	@Positive(message = "Owner's id must be > 0")
	@Schema(description = "The id of owner of the boarding record", example = "1")
	private Long ownerId;

	@Schema(description = "The start date of filter", example = "2026-07-30")
	private LocalDate fromDate;

	@Schema(description = "The end date of filter", example = "2026-08-23")
	private LocalDate toDate;

	@JsonIgnore
	@AssertTrue(message = "The end date of the filter must be after or equal to the start date of the filter")
	public boolean isDateRangeValid() {
		if (fromDate != null && toDate != null) {
			return !toDate.isBefore(fromDate);
		}
		return true;
	}

	public FilterRequestParam(BoardingStatus boardingRecordStatus, PetType petType, Long ownerId, LocalDate fromDate,
			LocalDate toDate) {
		super();
		this.boardingRecordStatus = boardingRecordStatus;
		this.petType = petType;
		this.ownerId = ownerId;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public FilterRequestParam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardingStatus getBoardingRecordStatus() {
		return boardingRecordStatus;
	}

	public void setBoardingRecordStatus(BoardingStatus boardingRecordStatus) {
		this.boardingRecordStatus = boardingRecordStatus;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

}
