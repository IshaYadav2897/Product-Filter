package com.flipkart.util;

import java.util.List;

import com.flipkart.model.FilterCriteria;

public class FlipkartUtil {

	public static boolean invalidFilterCriteria(FilterCriteria filterCriteria) {
		if (!isValidDouble(filterCriteria.getMinPrice()) || !isValidDouble(filterCriteria.getMaxPrice())
				|| !isValidDouble(filterCriteria.getMinRating()))
			return true;
		else if (!isValidListOfInt(filterCriteria.getBrands()) || !isValidListOfInt(filterCriteria.getOffers()))
			return true;
		else if (filterCriteria.getMinPrice() > filterCriteria.getMaxPrice())
			return true;
		else
			return false;
	}
	
	public static boolean isValidDouble(double number) {
		if (number > 0)
			return true;
		else
			return false;
	}
	
	public static boolean isValidListOfInt(List<Integer> numbers) {
		for (Integer number : numbers)
		{
			if (number < 0)
				return false;
		}
			return true;
	}
}
