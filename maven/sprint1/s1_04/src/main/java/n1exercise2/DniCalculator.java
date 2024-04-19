package n1exercise2;

public class DniCalculator {

    public char calculateDniLetter(int dniNumber) {
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letters.charAt(dniNumber % 23);
    }
}


