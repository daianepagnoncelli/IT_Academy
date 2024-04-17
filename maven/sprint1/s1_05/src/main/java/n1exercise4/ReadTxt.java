package n1exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ReadTxt {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter the directory or file path you want to check:");
            String path = scanner.nextLine();
            File file = new File(path);

            if (file.exists() && file.isDirectory()) {
                listRecursiveDirectory(path);
                System.out.println("The directory listing has been saved to 'directory_listing.txt'.");
            } else if (file.exists() && file.isFile()) {
                readTxt(file);
            } else {
                System.err.println("The path does not exist.");
            }
        }
    }

    public static void readTxt(File file) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
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

    public static void listRecursiveDirectory(String path) {
        File folder = new File(path);
        if (folder.isDirectory()) {
            File[] directory = folder.listFiles();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            if (directory != null) {
                Arrays.sort(directory);
                for (File file : directory) {
                    if (file.isDirectory()) {
                        saveToFile("directory_listing.txt", "D:" + file.getName() + " "
                                + ("Last modified: " + dateFormat.format(file.lastModified())));
                        listRecursiveDirectory(file.getAbsolutePath());
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
}

