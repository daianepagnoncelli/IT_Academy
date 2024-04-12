package n1exercise2;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", "Doe", 30);
        String message = "Hello, world!";
        int number = 42;

        // Call the generic method with different types of parameters
        GenericMethods.printGeneric(person, message, number);
    }
}
