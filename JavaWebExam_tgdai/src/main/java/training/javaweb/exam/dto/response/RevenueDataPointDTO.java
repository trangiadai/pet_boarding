package training.javaweb.exam.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class RevenueDataPointDTO {
	@Schema(description = "Period label (e.g., 'Month 1', 'Quarter 1')", example = "Month 1")
	private String label;

	@Schema(description = "Period number (1-12 for month, 1-4 for quarter)", example = "1")
	private int period;

	@Schema(description = "Total revenue for this period", example = "2500000")
	private long revenue;

	public RevenueDataPointDTO(String label, int period, long revenue) {
		super();
		this.label = label;
		this.period = period;
		this.revenue = revenue;
	}

	public RevenueDataPointDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public long getRevenue() {
		return revenue;
	}

	public void setRevenue(long revenue) {
		this.revenue = revenue;
	}

}