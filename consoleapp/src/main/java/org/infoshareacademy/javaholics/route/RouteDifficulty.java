package org.infoshareacademy.javaholics.route;

public enum RouteDifficulty {
    EASY("łatwa"),
    MEDIUM("średnia"),
    HARD("ciężka"),
    EXTREME("wymagająca");

    public final String difficulty;

    RouteDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
