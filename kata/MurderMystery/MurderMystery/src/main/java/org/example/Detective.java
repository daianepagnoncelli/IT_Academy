package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Detective {
    private final Map<String, Suspect> suspectMap;
    private final List<Clue> clues;

    public Detective(List<Suspect> suspects, List<Clue> clues) {
        //What size is suspectMap?
        this.suspectMap = suspects.stream()
                .collect(Collectors.toMap(Suspect::getName, suspect -> suspect));
        this.clues = clues;
    }

    public void investigate() {
        clues.stream()
                .filter(Clue::isRelevant)
                .forEach(clue -> {
                    Suspect suspect = suspectMap.get(clue.getRelatedSuspect());
                    if (suspect != null) {
                        interrogate(suspect, clue);
                    }
                });
    }

    private void interrogate(Suspect suspect, Clue clue) {
        //How many suspects are being questioned? Write it in order
        if (clue.getDescription().contains(suspect.getAlibi())) {
            System.out.println(suspect.getName() + " has a solid alibi.");
        } else {
            suspect.setGuilty(true);
        }
    }

    public Suspect findCulprit() {
        return suspectMap.values().stream()
                .filter(Suspect::isGuilty)
                .findFirst()
                .orElse(null);
    }
}

