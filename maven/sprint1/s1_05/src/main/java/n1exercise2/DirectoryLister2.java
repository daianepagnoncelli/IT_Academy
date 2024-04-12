package n1exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryLister2 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DirectoryLister2 <directory_path>");
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

        Arrays.sort(files);

        for (File file : files) {
            String type = file.isDirectory() ? "D" : "F";
            String lastModified = formatDate(file.lastModified());

            System.out.println(type + " " + file.getName() + " (" + lastModified + ")");

            if (file.isDirectory()) {
                listDirectoryContents(file);
            }
        }
    }

    private static String formatDate(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date(timestamp));
    }
}

