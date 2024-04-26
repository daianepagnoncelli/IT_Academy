package n2exercise1;

public class Person {
    private final String firstname;
    private final String lastname;
    private final int age;

    public Person(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + ", Age: " + age;
    }
}
