package org.infoshareacademy.javaholics;

import org.infoshareacademy.javaholics.user.User;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        TestObject test1 = new TestObject("test1.imie", "Test1.nazwisko", "TesterAlpha");
        TestObject test2 = new TestObject("test2.imie", "Test2.nazwisko", "TesterBeta");

        User user1 = new User(111L, "Jan1", "login1");
        User user2 = new User(222L, "Jan2", "login2");

//        działa - spr konwertera json
//        System.out.println(FileService.toJson(test1));

//        NIE działa - nie wiem czy obiekt user jest za skomplikowany, czy ma typy nie dajce sie przerzucić do jsona?
//        System.out.println(FileService.toJson(user1));

//        Sprawdzenie czy sciezka działa - działa
//        System.out.println(FileService.getPathUsersFile().toString());

       FileService.writeObjectToJsonFile(test1, FileService.getPathUsersFile());
       FileService.writeObjectToJsonFile(test2, FileService.getPathUsersFile());


    }



}