package n1exercise2;

public class DniCalculator {
    public static char calculateDniLetter(int dniNumber) {
        // The calculation of the DNI letter involves a simple arithmetic operation.
        // Let's perform this operation and return the corresponding letter.

        // Step 1: Calculate the remainder of dividing the DNI number by 23.
        int remainder = dniNumber % 23;

        // Step 2: Map the remainder value to the corresponding letter.
        char[] dniLetters = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return dniLetters[remainder];
    }
}

