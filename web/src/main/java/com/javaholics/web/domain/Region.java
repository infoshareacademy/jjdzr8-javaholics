package com.javaholics.web.domain;

public enum Region {

    DOLNOSLASKIE ("dolnośląskie"),
    KUJAWKSOPOMORSKIE ("kujawsko-pomorskie"),
    LUBELSKIE ("lubelskie"),
    LUBUSKIE ("lubuskie"),
    LODZKIE ("łódzkie"),
    MALOPOLSKIE ("małopolskie"),
    MAZOWIECKIE ("mazowieckie"),
    OPOLSKIE ("opolskie"),
    PODKARPACKIE ("podkarpackie"),
    PODLASKIE ("podlaskie"),
    POMORSKIE ("pomorskie"),
    SLASKIE ("śląskie"),
    SWIETOKRZYSKIE ("świętokrzyskie"),
    WARMINSKOMAZURSKIE ("warmińsko-mazurskie"),
    WIELKOPOLSKIE ("wielkopolskie"),
    ZACHODNIOPOMORSKIE ("zachodniopomorskie");

public final String regionName;

    Region(String region) {
        this.regionName = region;
    }

    public String getRegionName() {
        return regionName;
    }
}
