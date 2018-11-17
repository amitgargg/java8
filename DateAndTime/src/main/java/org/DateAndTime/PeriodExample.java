package org.DateAndTime;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodExample {

	public static void main(String[] args) {
		LocalDate dateOfBirth = LocalDate.of(1990, Month.SEPTEMBER, 4);
		LocalDate now = LocalDate.now();

		Period period = Period.between(dateOfBirth, now);

		Long yearsDifference = period.get(ChronoUnit.YEARS);
		Long monthDifference = period.get(ChronoUnit.MONTHS);

		Long totalNoOfMonthsDifference = dateOfBirth.until(now, ChronoUnit.MONTHS);

		System.out.println("No Of Years Difference: " + yearsDifference);
		System.out.println("No Of Months Difference: " + monthDifference);
		System.out.println("Total No Of Months Difference: " + totalNoOfMonthsDifference);

	}

}


