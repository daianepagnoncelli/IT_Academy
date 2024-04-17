package n1exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class RecursiveDirectory {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        if (args.length == 0) {

            System.out.println("Enter the directory path you want to check:");
            String path = scanner.nextLine();
            File directoryToCheck = new File(path);

            if (directoryToCheck.exists() && directoryToCheck.isDirectory()) {

                try {
                    listRecursiveDirectory(directoryToCheck);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } else {

                System.err.println("The path does not exist.");
            }
        }

    }

    public static void listRecursiveDirectory(File directory) throws FileNotFoundException {

        File[] filesInDirectory = directory.listFiles();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        Arrays.sort(filesInDirectory);

        for (int i = 0; i < filesInDirectory.length; i++) {

            if (filesInDirectory[i].isDirectory()) {

                System.out.println("D:" + filesInDirectory[i].getName() + " "
                        + ("Last modified: " + dateFormat.format(filesInDirectory[i].lastModified())));

                String newPath = filesInDirectory[i].getAbsolutePath();

                listRecursiveDirectory(new File(newPath));

            } else {

                System.out.println("F:" + filesInDirectory[i].getName() + " "
                        + ("Last modified: " + dateFormat.format(filesInDirectory[i].lastModified())));
            }

        }

    }

}
