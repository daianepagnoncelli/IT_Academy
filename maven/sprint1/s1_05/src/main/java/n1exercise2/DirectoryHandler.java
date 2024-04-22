package n1exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryHandler {

    public void listDirectoryTree(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            System.err.println("Error: Directory not found.");
            return;
        }

        listDirectoryTree(directory, 0);
    }

    private void listDirectoryTree(File directory, int depth) {

        if (directory.isDirectory()) {
            System.out.println(getIndent(depth) + "D: " + directory.getName() + " (Last Modified: " + formatDate(directory.lastModified()) + ")");
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.sort(files);
                for (File file : files) {
                    if (file.isDirectory()) {
                        listDirectoryTree(file, depth + 1);
                    } else {
                        System.out.println(getIndent(depth + 1) + "F: " + file.getName() + " (Last Modified: " + formatDate(file.lastModified()) + ")");
                    }
                }
            }
        }
    }

    private String getIndent(int depth) {
        return "  ".repeat(depth); // Using String.repeat() for indentation
    }

    private String formatDate(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timestamp));
    }
}
