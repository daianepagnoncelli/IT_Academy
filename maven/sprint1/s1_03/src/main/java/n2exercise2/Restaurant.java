package n2exercise2;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant> {

    private final String name;
    private final int score;

    public Restaurant(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Restaurant other = (Restaurant) obj;
        return name.equals(other.name) && score == other.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Restaurant other) {
        int nameComparison = name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return score - other.score;
    }

    @Override
    public String toString() {
        return "name: " + name + ", score: " + score;
    }
}
