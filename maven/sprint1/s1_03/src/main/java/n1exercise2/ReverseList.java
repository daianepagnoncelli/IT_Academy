package n1exercise2;

import java.util.List;
import java.util.ListIterator;

public class ReverseList {
    public void insertReverse(List<Integer> sourceList, List<Integer> targetList) {
        ListIterator<Integer> listIterator = sourceList.listIterator(sourceList.size());

        while (listIterator.hasPrevious()) {
            Integer element = listIterator.previous();
            targetList.add(element);

        }
    }
}