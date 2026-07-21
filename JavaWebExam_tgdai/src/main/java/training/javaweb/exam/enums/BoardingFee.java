package training.javaweb.exam.enums;

public enum BoardingFee {
	OVERDUE_CHARGE_PERCENTAGE(0.2);

	private final double value;

	private BoardingFee(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}

}
