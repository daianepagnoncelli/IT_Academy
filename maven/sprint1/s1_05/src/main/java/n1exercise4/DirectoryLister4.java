package n1exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

    public class DirectoryLister4 {

        public static void main(String[] args) {
            if (args.length != 1) {
                System.out.println("Usage: java DirectoryLister4 <directory_path>");
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

            try (FileWriter writer = new FileWriter("output_ex4.txt")) {
                for (File file : files) {
                    String type = file.isDirectory() ? "D" : "F";
                    String lastModified = formatDate(file.lastModified());

                    String line = type + " " + file.getName() + " (" + lastModified + ")\n";
                    writer.write(line);

                    if (file.isDirectory()) {
                        listDirectoryContents(file);
                    } else if (file.getName().toLowerCase().endsWith(".txt")) {
                        displayFileContents(file);
                    }
                }
                System.out.println("Directory listing saved to output_ex4.txt.");
            } catch (IOException e) {
                System.err.println("Error writing to output_ex4.txt: " + e.getMessage());
            }
        }

        private static void displayFileContents(File file) {
            if (!file.isFile() || !file.getName().toLowerCase().endsWith(".txt")) {
                System.out.println("The specified file is not a valid text file.");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                System.out.println("Contents of " + file.getName() + ":");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        private static String formatDate(long timestamp) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(new Date(timestamp));
        }
    }



