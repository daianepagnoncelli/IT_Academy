package n2exercise1;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Juan", "Sanchez", 42);
        String stringData = "Pastel";
        int intData = 242;

        GenericMethods.printGenericData(person1, stringData, intData);
        GenericMethods.printGenericData(intData, person1, stringData);
    }
}

