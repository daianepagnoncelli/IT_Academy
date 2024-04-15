package n1exercise2;

import java.util.List;
import java.util.stream.Collectors;

public class StringFilter {
    public static List<String> filterStringsWithLetterO(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o"))
                .collect(Collectors.toList());
    }

    public static List<String> filterStringsWithLetterOAndLength(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o") && s.length() > 5)
                .collect(Collectors.toList());
    }
}
