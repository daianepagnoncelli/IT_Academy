package n1exercise1;

public class Main {
    public static void main(String[] args) {
        NoGenericMethods example = new NoGenericMethods("Object1", "Object2", "Object3");
        System.out.println("Object1: " + example.getObject1());
        System.out.println("Object2: " + example.getObject2());
        System.out.println("Object3: " + example.getObject3());

        example.setObject1("New Object1");
        example.setObject2("New Object2");
        example.setObject3("New Object3");

        System.out.println("\nAfter modification:");
        System.out.println("Object1: " + example.getObject1());
        System.out.println("Object2: " + example.getObject2());
        System.out.println("Object3: " + example.getObject3());
    }
}
