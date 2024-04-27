package n2exercise2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = NumbersProvider.getNumbers();

        String result = NumbersFormatter.formatNumbers(numbers);

        System.out.println("Formatted numbers: " + result);
    }
}
