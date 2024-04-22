package n1exercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();

        months.add(new Month("January"));
        months.add(new Month("February"));
        months.add(new Month("March"));
        months.add(new Month("April"));
        months.add(new Month("May"));
        months.add(new Month("June"));
        months.add(new Month("July"));
        months.add(new Month("September"));
        months.add(new Month("October"));
        months.add(new Month("November"));
        months.add(new Month("December"));

        months.add(7, new Month("August"));

        System.out.println("****Months in ArrayList****");
        for (Month month : months) {
            System.out.println(month.getName());
        }

        Set<Month> uniqueMonths = new HashSet<>(months);

        int originalSize = months.size();
        int uniqueSize = uniqueMonths.size();
        boolean hasDuplicates = originalSize != uniqueSize;

        if (hasDuplicates) {
            System.out.println("Duplicates found when converting to HashSet.");
        } else {
            System.out.println("No duplicates found when converting to HashSet.");
        }

        System.out.println("\n****Unique Months in HashSet****");
        for (Month month : uniqueMonths) {
            System.out.println(month.getName());
        }

        System.out.println("\n****HashSet Iterator****");
        Iterator<Month> iterator = uniqueMonths.iterator();
        while (iterator.hasNext()) {
            Month month = iterator.next();
            System.out.println(month.getName());
        }
    }
}


