package org.example;

public class Suspect {
    private String name;
    private boolean guilty;
    private String alibi;

    public Suspect(String name, String alibi) {
        this.name = name;
        this.guilty = false;
        this.alibi = alibi;
    }

    public String getName() {
        return name;
    }

    public boolean isGuilty() {
        return guilty;
    }

    public void setGuilty(boolean guilty) {
        this.guilty = guilty;
    }

    public String getAlibi() {
        return alibi;
    }
}