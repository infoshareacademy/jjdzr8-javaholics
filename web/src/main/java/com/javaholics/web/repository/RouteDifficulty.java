package com.javaholics.web.repository;

public enum RouteDifficulty {
    EASY("Łatwa"),
    MEDIUM("Średnia"),
    HARD("Trudna"),
    EXTREME("Zaawansowana");


    public final String difficulty;

    RouteDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
