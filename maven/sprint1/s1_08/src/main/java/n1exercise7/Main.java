package n1exercise7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> mixedList = new ArrayList<>();
        mixedList.add("banana");
        mixedList.add(3);
        mixedList.add("apple");
        mixedList.add(10);
        mixedList.add("orange");
        mixedList.add(7);
        mixedList.add("grape");

        mixedList.sort(Comparator.comparingInt(o -> -o.toString().length()));

        System.out.println("Sorted list with strings from longest to shortest:");
        for (Object item : mixedList) {
            System.out.println(item);
        }
    }
}

