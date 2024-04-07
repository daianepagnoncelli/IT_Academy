package n1exercise2;

public class DniCalculator {

	public static char calculateDniLetter(int number) {
		String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
		return letters.charAt(number % 23);
	}
}
