package n1exercise3;

import java.util.*;

public class Main {
    private static final int NUM_QUESTIONS = 10;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("src/main/java/n1exercise3/countries.txt");

        HashMap<String, String> countryCapitalMap = fileHandler.getCountryCapitalMap();

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        int score = playQuiz(countryCapitalMap);

        fileHandler.saveResultsToFile(userName, score);

        scanner.close();
    }

    private static int playQuiz(HashMap<String, String> countryCapitalMap) {
        System.out.println("Let's start the quiz!");
        int score = 0;
        Random random = new Random();

        List<String> countries = new ArrayList<>(countryCapitalMap.keySet());
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            String randomCountry = countries.get(random.nextInt(countries.size()));
            String capital = countryCapitalMap.get(randomCountry);

            System.out.print("What is the capital of " + randomCountry + "? ");
            String userAnswer = scanner.nextLine().trim();

            if (userAnswer.equalsIgnoreCase(capital)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The capital of " + randomCountry + " is " + capital);
            }
        }
        return score;
    }
}