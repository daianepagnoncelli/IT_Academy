package n1exercise1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("dog", "cat", "bird", "snake", "monkey");

        List<String> result = StringFilter.filterStringsContainingO(strings);

        System.out.println("Strings containing 'o': " + result);
    }
}
