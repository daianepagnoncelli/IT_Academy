package n1exercise3;

import java.io.IOException;
import java.util.Scanner;

public class DirectoryLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Enter the directory path you want to check:");
            String path = scanner.nextLine();
            String outputFile = "Files.txt";

            try {
                DirectoryHandler directoryHandler = new DirectoryHandler();
                directoryHandler.listFilesSorted(path, outputFile);
                System.out.println("Directory listing saved to " + outputFile + ".");
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Please execute this program without arguments. Use it only for command line input.");
        }

        scanner.close();
    }
}



