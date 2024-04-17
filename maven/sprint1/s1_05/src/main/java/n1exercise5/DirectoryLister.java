package n1exercise5;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class DirectoryLister {
    public void listRecursiveDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    if (file.isDirectory()) {
                        saveToFile("directory_listing.txt", "D:" + file.getName() + " "
                                + ("Last modified: " + dateFormat.format(file.lastModified())));
                        listRecursiveDirectory(file);
                    } else {
                        saveToFile("directory_listing.txt", "F:" + file.getName() + " "
                                + ("Last modified: " + dateFormat.format(file.lastModified())));
                    }
                }
            } else {
                System.err.println("The directory is empty.");
            }
        } else {
            System.err.println("The path does not point to a directory.");
        }
    }

    public void saveToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(content + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

