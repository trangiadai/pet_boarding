package training.javaweb.exam.enums;

public enum BoardingDiscount {
	SEVEN_DAYS_DISCOUNT(7, 0.05), FOURTHTEEN_DAYS_DISCOUNT(14, 0.1);

	private final int day;
	private final double discount;

	private BoardingDiscount(int day, double discount) {
		this.day = day;
		this.discount = discount;
	}

	public int getDay() {
		return this.day;
	}

	public double getDiscount() {
		return discount;
	}

}
