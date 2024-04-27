package n2exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class NumbersFormatter {
    public static String formatNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> (num % 2 == 0 ? "e" : "o") + num)
                .collect(Collectors.joining(", "));
    }
}

