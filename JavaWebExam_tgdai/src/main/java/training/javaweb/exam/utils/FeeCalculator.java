package training.javaweb.exam.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import training.javaweb.exam.dto.response.FeeResult;
import training.javaweb.exam.enums.BoardingDiscount;
import training.javaweb.exam.enums.BoardingFee;

public class FeeCalculator {

	public static FeeResult calculateCheckOutFee(LocalDate checkIn, LocalDate expectedCheckOut,
			LocalDate actualCheckOut, long dailyRate) {

		long expectedDays = ChronoUnit.DAYS.between(checkIn, expectedCheckOut);
		if (expectedDays <= 0) {
			expectedDays = 1;
		}
		long actualDays = ChronoUnit.DAYS.between(checkIn, actualCheckOut);
		if (actualDays <= 0) {
			actualDays = 1;
		}

		long baseFee;
		long lateFee = 0;
		long daysForDiscount;

		if (actualCheckOut.isAfter(expectedCheckOut)) {
			baseFee = actualDays * dailyRate;
			long lateDays = ChronoUnit.DAYS.between(expectedCheckOut, actualCheckOut);
			lateFee = Math.round(lateDays * dailyRate * BoardingFee.OVERDUE_CHARGE_PERCENTAGE.getValue());
			daysForDiscount = actualDays;
		} else {
			baseFee = expectedDays * dailyRate;
			lateFee = 0;
			daysForDiscount = expectedDays;
		}

		long totalBeforeDiscount = baseFee + lateFee;

		double discountPercent = 0.0;
		if (daysForDiscount >= BoardingDiscount.FOURTHTEEN_DAYS_DISCOUNT.getDay()) {
			discountPercent = BoardingDiscount.FOURTHTEEN_DAYS_DISCOUNT.getDiscount();
		} else if (daysForDiscount >= BoardingDiscount.SEVEN_DAYS_DISCOUNT.getDay()) {
			discountPercent = BoardingDiscount.SEVEN_DAYS_DISCOUNT.getDiscount();
		}

		long discountAmount = Math.round(totalBeforeDiscount * discountPercent);
		long finalTotalFee = totalBeforeDiscount - discountAmount;

		return new FeeResult(baseFee, lateFee, discountAmount, finalTotalFee);
	}

	public static FeeResult calculateOngoingFee(LocalDate checkIn, LocalDate expectedCheckOut, LocalDate today,
			long dailyRate) {
		long expectedDays = ChronoUnit.DAYS.between(checkIn, expectedCheckOut);
		if (expectedDays <= 0) {
			expectedDays = 1;
		}

		long currentDaysSoFar = ChronoUnit.DAYS.between(checkIn, today);
		if (currentDaysSoFar <= 0) {
			currentDaysSoFar = 1;
		}

		long baseFee;
		long lateFee = 0;
		long daysForDiscount;

		if (today.isAfter(expectedCheckOut)) {
			baseFee = currentDaysSoFar * dailyRate;
			long lateDays = ChronoUnit.DAYS.between(expectedCheckOut, today);
			lateFee = Math.round(lateDays * dailyRate * BoardingFee.OVERDUE_CHARGE_PERCENTAGE.getValue());
			daysForDiscount = currentDaysSoFar;
		} else {
			baseFee = currentDaysSoFar * dailyRate;
			lateFee = 0;
			daysForDiscount = currentDaysSoFar;
		}

		long totalBeforeDiscount = baseFee + lateFee;
		double discountPercent = 0.0;
		if (daysForDiscount >= BoardingDiscount.FOURTHTEEN_DAYS_DISCOUNT.getDay()) {
			discountPercent = BoardingDiscount.FOURTHTEEN_DAYS_DISCOUNT.getDiscount();
		} else if (daysForDiscount >= BoardingDiscount.SEVEN_DAYS_DISCOUNT.getDay()) {
			discountPercent = BoardingDiscount.SEVEN_DAYS_DISCOUNT.getDiscount();
		}

		long discountAmount = Math.round(totalBeforeDiscount * discountPercent);
		long finalTotalFee = totalBeforeDiscount - discountAmount;

		return new FeeResult(baseFee, lateFee, discountAmount, finalTotalFee);
	}

}