package n1exercise1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        
    	ArrayList<Month> monthList = new ArrayList<>();
        
        monthList.add(new Month("January"));
        monthList.add(new Month("February"));
        monthList.add(new Month("March"));
        monthList.add(new Month("April"));
        monthList.add(new Month("May"));
        monthList.add(new Month("June"));
        monthList.add(new Month("July"));
        monthList.add(new Month("September"));
        monthList.add(new Month("October"));
        monthList.add(new Month("November"));
        monthList.add(new Month("December"));
        
        //Insert August
        monthList.add(7, new Month("August"));

        //the order
        System.out.println("ArrayList mantém a ordem correta:");
        for (Month month : monthList) {
            System.out.println(month.getName());
        }

        HashSet<Month> monthSet = new HashSet<>(monthList);
        
        System.out.println("\nHashSet não permite duplicatas:");
        for (Month month : monthSet) {
            System.out.println(month.getName());
        }

        System.out.println("\nIterando através da lista com um for:");
        for (int i = 0; i < monthList.size(); i++) {
            Month month = monthList.get(i);
            System.out.println(month.getName());
        }

        System.out.println("\nIterando através da lista com um iterator:");
        Iterator<Month> iterator = monthList.iterator();
        while (iterator.hasNext()) {
            Month month = iterator.next();
            System.out.println(month.getName());
        }
    }
}