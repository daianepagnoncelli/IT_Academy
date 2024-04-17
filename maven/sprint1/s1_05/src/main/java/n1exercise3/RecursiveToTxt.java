package n1exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveToTxt {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Enter the directory path you want to check:");
            String path = scanner.nextLine();
            File directoryToCheck = new File(path);

            if (directoryToCheck.exists() && directoryToCheck.isDirectory()) {
                try {
                    listRecursiveDirectoryToTxt(directoryToCheck);
                    System.out.println("The directory listing has been saved to 'directory_listing.txt'.");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.err.println("The path does not exist or is not a directory.");
            }
        }
    }

    public static void saveToFile(String fileName, String content) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(content + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listRecursiveDirectoryToTxt(File directory) throws FileNotFoundException {
        File[] filesInDirectory = directory.listFiles();

        if (filesInDirectory != null) { // Handle case when directory is empty
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            Arrays.sort(filesInDirectory);

            for (File file : filesInDirectory) {
                if (file.isDirectory()) {
                    saveToFile("directory_listing.txt", "D:" + file.getName() + " - "
                            + ("Last modified: " + dateFormat.format(file.lastModified())));
                    listRecursiveDirectoryToTxt(file); // Recursively process subdirectories
                } else {
                    saveToFile("directory_listing.txt", "F:" + file.getName() + " - "
                            + ("Last modified: " + dateFormat.format(file.lastModified())));
                }
            }
        } else {
            System.out.println("The directory is empty.");
        }
    }
}

