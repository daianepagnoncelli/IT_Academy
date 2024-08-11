package org.example;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class MurderMystery {

    private static final String ORIGINAL_HASH = "your_original_hash_here";

    public static void main(String[] args) {

        if (!isDebugging()) {
            throw new RuntimeException("The program must be run in debug mode!");
        }

        List<Suspect> suspects = new ArrayList<>();
        suspects.add(new Suspect("Alice", "cinema"));
        suspects.add(new Suspect("Bob", "home"));
        suspects.add(new Suspect("Charlie", "work"));

        List<Clue> clues = new ArrayList<>();
        clues.add(new Clue("Someone saw Alice at the cinema", false, "Alice"));
        clues.add(new Clue("Murder weapon found at Bob's house", true, "Bob"));
        clues.add(new Clue("Charlie has a solid alibi", false, "Charlie"));
        clues.add(new Clue("Fingerprint at the crime scene", true, "Bob"));

        Detective detective = new Detective(suspects, clues);
        detective.investigate();

        //Who is guilty? What is your alibi?
        Suspect culprit = detective.findCulprit();
    }

    private static boolean isDebugging() {
        for (String argument : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            if (argument.contains("jdwp")) {
                return true;
            }
        }
        return false;
    }
}