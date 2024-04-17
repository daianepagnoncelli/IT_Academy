package n1exercise5;

import java.io.*;

public class SerializationDeserialization {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java SerializationDeserialization <directory>");
            return;
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            DirectoryLister lister = new DirectoryLister();
            lister.listRecursiveDirectory(directory);
            System.out.println("The directory listing has been saved to 'directory_listing.txt'.");

            // Serialization and deserialization
            FileData fileData = new FileData("file", "F", "01/10/2023 16:15");

            serialize(fileData);
            deserialize();
        } else {
            System.err.println("The path does not exist.");
        }
    }

    public static void serialize(FileData fileData) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serialized_file.ser"))) {
            outputStream.writeObject(fileData);
            System.out.println("Object serialized.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialize() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serialized_file.ser"))) {
            FileData deserializedFileData = (FileData) inputStream.readObject();
            System.out.println("Object deserialized: " + deserializedFileData);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

