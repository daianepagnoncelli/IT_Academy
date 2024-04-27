package n2exercise1;

import java.util.List;
import java.util.stream.Collectors;

public class NamesFilter {
    public static List<String> filterNames(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("A") && name.length() == 3)
                .collect(Collectors.toList());
    }
}

