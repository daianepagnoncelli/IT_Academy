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

        List<Integer> secondList = new ArrayList<>();

        ReverseList inserter = new ReverseList();
        inserter.insertReverse(firstList, secondList);

        System.out.println("Segund list (Elements of the first list in reverse order):");
        for (Integer element : secondList) {
            System.out.println(element);
        }

    }
}
