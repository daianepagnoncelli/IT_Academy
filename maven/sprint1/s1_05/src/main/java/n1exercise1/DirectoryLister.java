package n1exercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DirectoryLister {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Enter the directory path you want to check:");
            String path = scanner.nextLine();

            try {
                listFilesSorted(path);
            } catch (FileNotFoundException e) {
                System.err.println("The path is invalid.");
            }

        } else {
            System.out.println("Please execute this program without arguments. Use it only for command line input.");
        }

    }

    public static void listFilesSorted(String path) throws FileNotFoundException {

        File folder = new File(path);

        File[] directory;

        if (folder.exists()) {

            directory = folder.listFiles();

            if (directory != null) {
                Arrays.sort(directory);

                for (File file : directory) {
                    System.out.println(file);
                }
            } else {
                System.out.println("The directory is empty.");
            }

        } else {
            System.err.println("The path is invalid.");
        }

    }

}

