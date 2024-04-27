package n3exercise1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ana", 20, 3, 8));
        students.add(new Student("Carlos", 22, 4, 6));
        students.add(new Student("Elena", 19, 2, 7));
        students.add(new Student("Diego", 21, 3, 4));
        students.add(new Student("Isabel", 23, 4, 9));
        students.add(new Student("Fernando", 20, 3, 5));
        students.add(new Student("Gabriela", 18, 2, 8));
        students.add(new Student("Hugo", 22, 4, 6));
        students.add(new Student("Inés", 21, 3, 7));
        students.add(new Student("Javier", 19, 2, 5));

        System.out.println("-> All students:");
        students.forEach(s -> System.out.println(s.getName() + ", " + s.getAge()));

        System.out.println("-> Students whose name starts with 'A':");
        List<Student> aStudents = students.stream()
                .filter(s -> s.getName().startsWith("A"))
                .toList();
        aStudents.forEach(s -> System.out.println(s.getName() + ", " + s.getAge()));

        System.out.println("-> Students with a grade of 5 or higher:");
        students.stream()
                .filter(s -> s.getGrade() >= 5)
                .forEach(s -> System.out.println(s.getName() + ", " + s.getAge()));

        System.out.println("-> Students with a grade of 5 or higher, not from PHP:");
        students.stream()
                .filter(s -> s.getGrade() >= 5 && !s.getName().equals("PHP"))
                .forEach(s -> System.out.println(s.getName() + ", " + s.getAge()));

        System.out.println("-> Students taking JAVA and of legal age:");
        students.stream()
                .filter(s -> s.getYear() == 3 && s.getAge() >= 18)
                .forEach(s -> System.out.println(s.getName() + ", " + s.getAge()));
    }
}

