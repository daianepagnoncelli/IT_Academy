package n2exercise3;

public class Main {
    public static void main(String[] args) {

        MathOperation addition = (a, b) -> a + b;
        MathOperation subtraction = (a, b) -> a - b;
        MathOperation multiplication = (a, b) -> a * b;
        MathOperation division = (a, b) -> {
            if (b != 0) {
                return a / b;
            } else {
                throw new IllegalArgumentException("Division by zero");
            }
        };

        System.out.println("Addition: " + addition.operation(5, 3));
        System.out.println("Subtraction: " + subtraction.operation(5, 3));
        System.out.println("Multiplication: " + multiplication.operation(5, 3));
        System.out.println("Division: " + division.operation(6, 2));
    }
}
