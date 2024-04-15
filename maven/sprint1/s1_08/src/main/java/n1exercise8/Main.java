package n1exercise8;

import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) {
        StringReverser reverser = new StringReverserImpl();

        String originalString = "hello";
        String reversedString = reverser.reverse(originalString);

        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);

        // Check if the result is correct
        String expectedReversedString = new StringBuilder(originalString).reverse().toString();
        System.out.println("Is the result correct? " + expectedReversedString.equals(reversedString));
    }
}
