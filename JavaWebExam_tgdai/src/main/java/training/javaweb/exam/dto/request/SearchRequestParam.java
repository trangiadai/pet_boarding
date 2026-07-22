package training.javaweb.exam.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;

public class SearchRequestParam {
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

	public SearchRequestParam(LocalDate fromDate, LocalDate toDate) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public SearchRequestParam() {
		super();
		// TODO Auto-generated constructor stub
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
