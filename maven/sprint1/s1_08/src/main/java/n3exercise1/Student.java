package n3exercise1;

public class Student {
    private String name;
    private int age;
    private int year;
    private int grade;

    public Student(String name, int age, int year, int grade) {
        this.name = name;
        this.age = age;
        this.year = year;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYear() {
        return year;
    }

    public int getGrade() {
        return grade;
    }
}

