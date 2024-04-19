package n1exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ReverseList {
    public static List<Integer> reverse(List<Integer> originalList) {

        List<Integer> reversedList = new ArrayList<>();
        ListIterator<Integer> iterator = originalList.listIterator(originalList.size());

        while (iterator.hasPrevious()) {
            Integer element = iterator.previous();
            reversedList.add(element);
        }

        return reversedList;
    }
}

