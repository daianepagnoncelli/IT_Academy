package n2exercise4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("123");
        items.add("elephant");
        items.add("cat");
        items.add("45");
        items.add("apple");

        items.sort(Comparator.comparingInt((String s) -> s.charAt(0))
                .thenComparing((s1, s2) -> {
                    if (s1.contains("e") && !s2.contains("e")) {
                        return -1;
                    } else if (!s1.contains("e") && s2.contains("e")) {
                        return 1;
                    } else {
                        return 0;
                    }
                }));

        items.replaceAll(s -> s.replace('a', '4'));

        items.stream()
                .filter(s -> s.matches("\\d+"))
                .forEach(System.out::println);
    }
}

