package n2exercise1;

public class Main {
    public static void main(String[] args) {
        byte age = Input.readByte("Enter your age: ");
        System.out.println("Your age is: " + age);

        int number = Input.readInt("Enter a number: ");
        System.out.println("The number entered is: " + number);

        float floatValue = Input.readFloat("Enter a float value: ");
        System.out.println("The float value entered is: " + String.format("%.6f", floatValue));

        double doubleValue = Input.readDouble("Enter a double value: ");
        System.out.println("The double value entered is: " + String.format("%.10f", doubleValue));

        char character = Input.readChar("Enter a character: ");
        System.out.println("The character entered is: " + character);

        String name = Input.readString("Enter your name: ");
        System.out.println("Your name is: " + name);

        boolean answer = Input.readIfNo("Please enter options (s/n): ");
        System.out.println("You answered: " + (answer ? "Yes" : "No"));

        Input.closeScanner();
    }

}
