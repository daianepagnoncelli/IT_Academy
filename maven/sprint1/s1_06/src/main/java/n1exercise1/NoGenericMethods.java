package n1exercise1;

public class NoGenericMethods {
    private final Person object1;
    private final Person object2;
    private final Person object3;

    public NoGenericMethods(Person object1, Person object2, Person object3) {
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
    }

    @Override
    public String toString() {
        return "NoGenericMethods{" +
                "object1=" + object1 +
                ", object2=" + object2 +
                ", object3=" + object3 +
                '}';
    }
}
