package n2exercise1;

public class GenericMethods {
    public static <T> void printGenericData(T one, T two, Object three) {
        System.out.println("Generic data one: " + one);
        System.out.println("Generic data two: " + two);
        System.out.println("Non-generic data three: " + three);
    }
}

