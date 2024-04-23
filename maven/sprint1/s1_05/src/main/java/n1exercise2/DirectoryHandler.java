package n1exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class DirectoryHandler {
    public void listFilesSorted(String path) throws FileNotFoundException {
        File folder = new File(path);

        if (folder.exists() && folder.isDirectory()) {
            listFilesRecursively(folder, 0);
        } else {
            throw new FileNotFoundException("The path is invalid or does not point to a directory.");
        }
    }

    private void listFilesRecursively(File folder, int depth) {
        File[] files = folder.listFiles();
        if (files == null) {
            System.out.println("The directory is empty.");
            return;
        }

        Arrays.sort(files);

        for (File file : files) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }


            if (file.isDirectory()) {
                System.out.print("D -> ");
                System.out.println(file.getName());
                listFilesRecursively(file, depth + 1);
            } else {
                System.out.print("F -> ");
                System.out.print(file.getName());
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.println(" (Last Modified: " + sdf.format(new Date(file.lastModified())) + ")");
            }
        }
    }
}

