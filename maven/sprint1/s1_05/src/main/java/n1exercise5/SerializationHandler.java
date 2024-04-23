package n1exercise5;

import java.io.*;

public class SerializationHandler {
    public static void serializeObject(Object object, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(object);
            out.close();

            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);

        } catch (IOException e) {
            System.err.println("Error occurred during serialization: " + e.getMessage());
        }
    }

    public static Object deserializeObject(String filename) {
        Object object = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            object = in.readObject();
            in.close();
            fileIn.close();

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred during deserialization: " + e.getMessage());
        }

        return object;
    }
}

