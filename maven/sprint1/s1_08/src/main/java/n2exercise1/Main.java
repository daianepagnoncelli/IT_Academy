package n2exercise1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = NamesProvider.getNames();

        List<String> filteredNames = NamesFilter.filterNames(names);

        System.out.println("Names starting with 'A' and having exactly 3 letters:");
        filteredNames.forEach(System.out::println);
    }
}

