package com.javaholics.web.repository;

public enum RouteDifficulty implements CharSequence {
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

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
}
