package n1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryLister3 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DirectoryLister3 <directory_path>");
            System.exit(1);
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified path is not a valid directory.");
            System.exit(1);
        }

        listDirectoryContents(directory);
    }

    private static void listDirectoryContents(File dir) {
        File[] files = dir.listFiles();

        if (files == null) {
            System.out.println("Unable to retrieve the list of files.");
            return;
        }

        Arrays.sort(files); // Sort files alphabetically

        try (FileWriter writer = new FileWriter("output_ex3.txt")) {
            for (File file : files) {
                String type = file.isDirectory() ? "D" : "F";
                String lastModified = formatDate(file.lastModified());

                String line = type + " " + file.getName() + " (" + lastModified + ")\n";
                writer.write(line);

                if (file.isDirectory()) {
                    listDirectoryContents(file); // Recursively list subdirectories
                }
            }
            System.out.println("Directory listing saved to output.txt.");
        } catch (IOException e) {
            System.err.println("Error writing to output.txt: " + e.getMessage());
        }
    }

    private static String formatDate(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(timestamp));
    }
}

