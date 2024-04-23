package n2exercise1;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryHandler {
    public void listFilesSorted(String path, String outputFilePath) throws IOException {
        File folder = new File(path);

        if (folder.exists() && folder.isDirectory()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                listFilesRecursively(folder, 0, writer);
            }
        } else {
            throw new FileNotFoundException("The path is invalid or does not point to a directory.");
        }
    }

    private void listFilesRecursively(File folder, int depth, BufferedWriter writer) throws IOException {
        File[] files = folder.listFiles();
        if (files == null) {
            writer.write("The directory is empty.");
            writer.newLine();
            return;
        }

        Arrays.sort(files);

        for (File file : files) {
            for (int i = 0; i < depth; i++) {
                writer.write("  ");
            }

            if (file.isDirectory()) {
                writer.write("D -> ");
                writer.write(file.getName());
                writer.newLine();
                listFilesRecursively(file, depth + 1, writer);
            } else {
                writer.write("F -> ");
                writer.write(file.getName());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                writer.write(" (Last Modified: " + sdf.format(new Date(file.lastModified())) + ")");
                writer.newLine();
            }
        }
    }
}
