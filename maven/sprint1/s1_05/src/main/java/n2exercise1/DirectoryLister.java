package n2exercise1;

import java.io.*;
import java.util.Properties;

public class DirectoryLister {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();

            try (InputStream inputStream = new FileInputStream(".\\src\\main\\java\\n2exercise1\\config.properties")) {
                properties.load(inputStream);
            } catch (IOException e) {
                System.err.println("Error loading configuration: " + e.getMessage());
                return;
            }

            String directoryPath = properties.getProperty("directory_to_read");
            String outputFilePath = properties.getProperty("output_file_path");

            DirectoryHandler directoryHandler = new DirectoryHandler();
            directoryHandler.listFilesSorted(directoryPath, outputFilePath);

            System.out.println("Directory listing saved to " + outputFilePath + ".");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}


