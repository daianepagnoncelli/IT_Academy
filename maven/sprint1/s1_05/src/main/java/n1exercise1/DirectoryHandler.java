package n1exercise1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;


public class DirectoryHandler {
    public void listFilesSorted(String path) throws FileNotFoundException {
        File folder = new File(path);
        File[] directory;

        if (folder.exists()) {
            directory = folder.listFiles();

            if (directory != null) {
                Arrays.sort(directory);

                for (File file : directory) {
                    System.out.println(file.getName()); // Only print the file name, not the full path
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            throw new FileNotFoundException("The path is invalid.");
        }
    }
}
