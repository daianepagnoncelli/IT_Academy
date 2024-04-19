package n1exercise3;

import java.io.*;
import java.util.*;

public class FileHandler {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    public HashMap<String, String> getCountryCapitalMap() {
        HashMap<String, String> countryCapitalMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length == 2) {
                    countryCapitalMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return countryCapitalMap;
    }

    public void saveResultsToFile(String userName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\itacademy\\maven\\sprint1\\s1_03\\src\\main\\java\\n1exercise3\\classificacio.txt", true))) {
            writer.println(userName + "," + score);
        } catch (IOException e) {
            System.out.println("Error saving results to file: " + e.getMessage());
        }
    }
}