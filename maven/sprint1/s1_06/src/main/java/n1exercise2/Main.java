package n1exercise2;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("John", "Doe", 30);
        String message = "Hello, compis!";
        int number = 42;

        GenericMethods.printGeneric(person, message, number);
    }
}
