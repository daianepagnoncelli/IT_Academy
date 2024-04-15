package n1exercise1;

import java.util.List;
import java.util.stream.Collectors;

public class StringFilter {
    public static List<String> filterStringsContainingO(List<String> strings) {
        return strings.stream()
                .filter(s -> s.contains("o"))
                .collect(Collectors.toList());
    }
}
