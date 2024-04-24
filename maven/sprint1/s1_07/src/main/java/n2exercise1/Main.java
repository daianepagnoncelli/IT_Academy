package n2exercise1;

import java.io.IOException;

public class Main {
    public static void serializeStudent(Student student, String directory) {
        try {
            ObjectSerializer.serializeToJson(student, directory);
            System.out.println("Student object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred during serialization: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Julio Cezar", 36);
        serializeStudent(student, "student.json");
    }
}