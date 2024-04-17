package n1exercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        ArrayList<Month> monthsList = new ArrayList<>();

        // ArrayList
        monthsList.add(new Month("January"));
        monthsList.add(new Month("February"));
        monthsList.add(new Month("March"));
        monthsList.add(new Month("April"));
        monthsList.add(new Month("May"));
        monthsList.add(new Month("June"));
        monthsList.add(new Month("July"));
        monthsList.add(new Month("September"));
        monthsList.add(new Month("October"));
        monthsList.add(new Month("November"));
        monthsList.add(new Month("December"));

        // Insert "August"
        monthsList.add(7, new Month("August"));

        // ArrayList
        System.out.println("ArrayList:");
        for (Month month : monthsList) {
            System.out.println(month.getName());
        }

        // ArrayList HashSet
        HashSet<Month> monthsSet = new HashSet<>(monthsList);

        // HashSet
        System.out.println("\nHashSet:");
        for (Month month : monthsSet) {
            System.out.println(month.getName());
        }

        // For
        System.out.println("\nIterating with for loop:");
        for (int i = 0; i < monthsList.size(); i++) {
            Month month = monthsList.get(i);
            System.out.println(month.getName());
        }

        //Iterator
        System.out.println("\nIterating with Iterator:");
        Iterator<Month> iterator = monthsList.iterator();
        while (iterator.hasNext()) {
            Month month = iterator.next();
            System.out.println(month.getName());
        }
    }
}