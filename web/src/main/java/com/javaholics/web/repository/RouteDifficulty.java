package com.javaholics.web.repository;

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
