package training.javaweb.exam.dto.response;

public class FeeResult {
	public final long baseFee;
	public final long lateFee;
	public final long discountAmount;
	public final long totalFee;

	public FeeResult(long baseFee, long lateFee, long discountAmount, long totalFee) {
		this.baseFee = baseFee;
		this.lateFee = lateFee;
		this.discountAmount = discountAmount;
		this.totalFee = totalFee;
	}

	public long getBaseFee() {
		return baseFee;
	}

	public long getLateFee() {
		return lateFee;
	}

	public long getDiscountAmount() {
		return discountAmount;
	}

	public long getTotalFee() {
		return totalFee;
	}

}
