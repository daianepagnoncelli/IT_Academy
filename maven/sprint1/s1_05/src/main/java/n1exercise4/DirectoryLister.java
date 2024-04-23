package n1exercise4;

import java.io.IOException;
import java.util.Scanner;

public class DirectoryLister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (args.length == 0) {
            System.out.println("Enter the file path you want to check:");
            String path = scanner.nextLine();

            DirectoryHandler directoryHandler = new DirectoryHandler();

            try {
                if (path.endsWith(".txt")) {
                    directoryHandler.displayTextFileContents(path);
                } else {
                    directoryHandler.listFilesSorted(path);
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Please execute this program without arguments. Use it only for command line input.");
        }

        scanner.close();
    }
}

