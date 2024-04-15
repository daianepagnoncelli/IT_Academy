package n1exercise2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "world", "java", "open", "closed", "loop");

        List<String> result1 = StringFilter.filterStringsWithLetterO(strings);
        List<String> result2 = StringFilter.filterStringsWithLetterOAndLength(strings);

        System.out.println("Strings containing letter 'o': " + result1);
        System.out.println("Strings containing letter 'o' and more than 5 letters: " + result2);
    }
}
