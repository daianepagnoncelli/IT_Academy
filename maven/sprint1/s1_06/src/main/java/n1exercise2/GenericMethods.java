package n1exercise2;

public class GenericMethods {
    public static <T> void printGenericData(T one, T two, T three) {
        System.out.println("Generic data one: " + one);
        System.out.println("Generic data two: " + two);
        System.out.println("Generic data three: " + three);
    }
}
