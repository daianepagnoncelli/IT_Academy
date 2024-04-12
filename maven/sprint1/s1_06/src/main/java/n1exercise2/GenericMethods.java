package n1exercise2;

public class GenericMethods {
    public static <T, U, V> void printGeneric(T obj1, U obj2, V obj3) {
        System.out.println("Object 1: " + obj1);
        System.out.println("Object 2: " + obj2);
        System.out.println("Object 3: " + obj3);
    }
}
