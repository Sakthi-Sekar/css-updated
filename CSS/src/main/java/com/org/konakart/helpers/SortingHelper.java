package com.org.konakart.helpers;

import java.util.List;

import org.openqa.selenium.WebElement;

public class SortingHelper {
	MonthConvertion month = new MonthConvertion();

	public String[] sortDate(List<WebElement> allDates) {
		String listOfDayDifference[] = new String[allDates.size() / 2];

		for (int index = 0; index < allDates.size() / 2; index++) {

			String date = allDates.get(index).getText();
			String[] dateArray = allDates.get(index).getText().split("\\s+", 2);
			String differenceOfDate = month.monthDifference(dateArray[1]);
			listOfDayDifference[index] = differenceOfDate;

		}

		return listOfDayDifference;
	}
	public  boolean isSortedDescending(final int[] data) {
	    for(int Arrindex = 1; Arrindex < data.length; Arrindex++) {
	        if(data[Arrindex-1] < data[Arrindex]) {
	            return false;
	        }
	    }
	    return true;
	}
	public  boolean isSortedAscending(final int[] data) {
	    for(int Arrindex = 1; Arrindex < data.length; Arrindex++) {
	        if(data[Arrindex-1] > data[Arrindex]) {
	            return false;
	        }
	    }
	    return true;
	}
	

}
