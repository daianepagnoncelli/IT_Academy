package n1exercise3;

import java.io.*;
import java.util.*;

public class Country {
    private Map<String, String> countriesMap = new HashMap<>();

    private Scanner scanner = new Scanner(System.in);

    public void startGame() {

        readCountries("C:\\itacademy\\s1_03\\src\\n1exercise3\\countries.txt");

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        int score = playGame();

        saveScore(userName, score);
    }

    private void readCountries(String filename) {

        try (Scanner fileScanner = new Scanner(new File(filename))) {

            boolean firstLine = true;

            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(" ", 2);

                if (firstLine) {
                    firstLine = false;

                    if (parts.length != 2) {
                        continue;
                    }
                }
                if (parts.length == 2) {
                    countriesMap.put(parts[0], parts[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            e.printStackTrace();
        }
    }

    private int playGame() {
        int score = 0;

        for (int i = 0; i < 10; i++) {
            String randomCountry = getRandomCountry();
            String capital = countriesMap.get(randomCountry);

            System.out.println("What is the capital of " + randomCountry + "?");
            String userGuess = scanner.nextLine();

            if (userGuess.equalsIgnoreCase(capital)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct capital is " + capital + ".");
            }
        }
        return score;
    }

    private String getRandomCountry() {
        List<String> keys = new ArrayList<>(countriesMap.keySet());
        return keys.get(new Random().nextInt(keys.size()));
    }

    private void saveScore(String userName, int score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\itacademy\\s1_03\\src\\n1exercise3\\classificacao.txt", true))) {
            writer.println(userName + "," + score);
        } catch (IOException e) {
            System.out.println("Error saving score.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Country game = new Country();
        game.startGame();
    }
}