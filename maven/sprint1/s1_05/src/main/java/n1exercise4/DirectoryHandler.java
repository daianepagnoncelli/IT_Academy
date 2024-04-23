package n1exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DirectoryHandler {
    public void listFilesSorted(String path) throws FileNotFoundException {
        File folder = new File(path);

        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Listing files in directory: " + path);
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            throw new FileNotFoundException("The path is invalid or does not point to a directory.");
        }
    }

    public void displayTextFileContents(String filePath) throws IOException {
        File file = new File(filePath);

        if (file.exists() && file.isFile() && filePath.endsWith(".txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                System.out.println("Contents of " + filePath + ":");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            throw new FileNotFoundException("The file is invalid or not a TXT file.");
        }
    }
}
