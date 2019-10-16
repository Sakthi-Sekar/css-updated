package com.org.konakart.helpers;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.testng.annotations.Test;

import com.org.konakrt.utils.ValidateTestResult;

public class ValidateDate {
	public void validateReviewDate() {
		LocalDate previousdate = LocalDate.of(2016, Month.JULY, 07);
		System.out.println(previousdate);
		ValidateTestResult.validateData(previousdate, "2016, Month.JULY, 07", "No match");

	}
}