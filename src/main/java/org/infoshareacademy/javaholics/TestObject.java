package org.infoshareacademy.javaholics;

import org.infoshareacademy.javaholics.user.SexChoice;

import java.awt.image.BufferedImage;

public class TestObject {

    private String name;
    private String lastName;
    private String login;

    private SexChoice sex;

    private Long id;

    public TestObject(String name, String lastName, String login, Long id) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.id = id;
    }
}
