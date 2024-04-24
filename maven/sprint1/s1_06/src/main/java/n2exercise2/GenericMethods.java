package n2exercise2;

public class GenericMethods {
    @SafeVarargs
    public static <T> void printGenericData(T... data) {
        for (T item : data) {
            System.out.println("Generic data: " + item);
        }
    }
}
