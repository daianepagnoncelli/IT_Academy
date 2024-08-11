package org.example;

public class Clue {
    private String description;
    private boolean relevant;
    private String relatedSuspect;

    public Clue(String description, boolean relevant, String relatedSuspect) {
        this.description = description;
        this.relevant = relevant;
        this.relatedSuspect = relatedSuspect;
    }

    public String getDescription() {
        return description;
    }

    public boolean isRelevant() {
        return relevant;
    }

    public String getRelatedSuspect() {
        return relatedSuspect;
    }
}
