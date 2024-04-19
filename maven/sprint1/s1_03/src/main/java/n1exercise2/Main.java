package n1exercise2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);

        System.out.println("Original list: " + firstList);

        List<Integer> secondList = ReverseList.reverse(firstList);

        System.out.println("Reversed list: " + secondList);
    }
}

