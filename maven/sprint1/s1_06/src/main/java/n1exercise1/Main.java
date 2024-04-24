package n1exercise1;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Juan", "Rodriguez", 36);
        Person person2 = new Person("Luis", "Morales", 35);
        Person person3 = new Person("Pablo", "Sanchez", 43);

        NoGenericMethods objects1 = new NoGenericMethods(person2, person1, person3);
        NoGenericMethods objects2 = new NoGenericMethods(person3, person1, person2);
        NoGenericMethods objects3 = new NoGenericMethods(person1, person2, person3);


        System.out.println(objects1);
        System.out.println(objects2);
        System.out.println(objects3);
    }
}


