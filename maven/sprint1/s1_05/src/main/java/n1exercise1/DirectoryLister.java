package n1exercise1;

import java.io.File;
import java.util.Arrays;

public class DirectoryLister {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("java DirectoryLister <caminho_do_diretorio>");
            System.exit(1);
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified path is not a valid directory.");
            System.exit(1);
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to retrieve the list of files.");
            return;
        }

        Arrays.sort(files);

        System.out.println("Contents of directory " + directoryPath + ":");
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

