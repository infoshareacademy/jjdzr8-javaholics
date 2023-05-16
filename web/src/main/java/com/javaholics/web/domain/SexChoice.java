package com.javaholics.web.domain;

public enum SexChoice {

    WOMAN ("Kobieta"),
    MAN ("Mężczyzna"),
    OTHER ("Inna");

public final String sexName;

    SexChoice(String sexName) {
        this.sexName = sexName;
    }
    public String getSex() {
        return sexName;
    }
}
