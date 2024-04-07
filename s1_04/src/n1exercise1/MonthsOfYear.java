package n1exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MonthsOfYear {

	public List<String> createMonthsList() {
		List<String> months = new ArrayList<>();
		months.add("January");
		months.add("February");
		months.add("March");
		months.add("April");
		months.add("May");
		months.add("June");
		months.add("July");
		months.add("August");
		months.add("September");
		months.add("October");
		months.add("November");
		months.add("December");

		Collections.sort(months); // Sorts the months in alphabetical order

		return months;
	}
}
