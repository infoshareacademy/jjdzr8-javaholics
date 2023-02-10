package com.javaholics.web.controller;

import java.awt.image.BufferedImage;

public class User {

    private Long id;
    private String name;
    private String lastName;
    private String login;
    // tu odniesienie do enum SexChoice
    private SexChoice sex;
    private String image;
    private String location;
    private String prefferedRegionEvents;
    private String dectription;

    //constructors

    public User(Long id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }


    // getters and setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public SexChoice getSex() {
        return sex;
    }
    public void setSex(SexChoice sex) {
        this.sex = sex;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPrefferedRegionEvents() {
        return prefferedRegionEvents;
    }
    public void setPrefferedRegionEvents(String prefferedRegionEvents) {
        this.prefferedRegionEvents = prefferedRegionEvents;
    }
    public String getDectription() {
        return dectription;
    }
    public void setDectription(String dectription) {
        this.dectription = dectription;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
