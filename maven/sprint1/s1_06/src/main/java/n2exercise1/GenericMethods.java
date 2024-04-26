package n2exercise1;

public class GenericMethods {
    public static <T, U> void printGenericData(T one, T two, U three) {
        System.out.println("Generic data (T one): " + one);
        System.out.println("Generic data (T two): " + two);
        System.out.println("No Generic data (U three): " + three);
    }
}


