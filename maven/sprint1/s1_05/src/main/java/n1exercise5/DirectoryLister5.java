package n1exercise5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.Serializable;


record SerializedObject(String directoryPath, String[] contents) implements Serializable {
    @java.io.Serial
    private static final long serialVersionUID = 1L;
}

public class DirectoryLister5 {

    private static final String DEFAULT_FILENAME = "serializedObject.ser";

    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2) {
            System.out.println("Usage: java DirectoryLister5 <directory_path> [output_filename]");
            System.exit(1);
        }

        File directory = new File(args[0]);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified path is not a valid directory.");
            System.exit(1);
        }

        String[] directoryContents = listDirectoryContents(directory);

        String filename = args.length > 1 ? args[1] : DEFAULT_FILENAME;

         serializeObject(new SerializedObject(args[0], directoryContents), filename);

        SerializedObject deserializedObject = deserializeObject(filename);
        if (deserializedObject != null) {
            System.out.println("Directory Path: " + deserializedObject.directoryPath());
            System.out.println("Directory Contents:");
            for (String item : deserializedObject.contents()) {
                System.out.println(item);
            }
        }
    }

    private static String[] listDirectoryContents(File dir) {
        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("Unable to retrieve the list of files.");
            return new String[0];
        }

        Arrays.sort(files);

        List<String> contents = new ArrayList<>();
        for (File file : files) {
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = formatDate(file.lastModified());

            String line = type + " " + file.getName() + " (" + lastModified + ")";
            contents.add(line);

            if (file.isDirectory()) {
                contents.addAll(Arrays.asList(listDirectoryContents(file)));
            } else if (file.getName().toLowerCase().endsWith(".txt")) {
                contents.add("Contents of " + file.getName() + ":");
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String fileLine;
                    while ((fileLine = reader.readLine()) != null) {
                        contents.add(fileLine);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
            }
        }

        return contents.toArray(new String[0]);
    }

    private static void serializeObject(SerializedObject object, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
            System.out.println("Serialized object saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
        }
    }

    private static SerializedObject deserializeObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            SerializedObject object = (SerializedObject) ois.readObject();
            System.out.println("Deserialized object from " + filename);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            return null;
        }
    }

    private static String formatDate(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }
}


