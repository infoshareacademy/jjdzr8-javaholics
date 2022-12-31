package org.infoshareacademy.javaholics;

import org.infoshareacademy.javaholics.event.Event;
import org.infoshareacademy.javaholics.event.Events;
import org.infoshareacademy.javaholics.route.Route;
import org.infoshareacademy.javaholics.route.Routes;
import org.infoshareacademy.javaholics.user.User;
import org.infoshareacademy.javaholics.user.Users;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

//      scenariusze testowe
        User user1 = new User(111L, "Jan1", "login1");
        Users.add(user1);
        User user2 = new User(222L, "Jan2", "login2");
        Users.add(user2);

        Route route1 = new Route(111L, "trasa1");
        Routes.add(route1);

        Event event1 = new Event(111L, new Date(2022-12-29), "17", user1);
        Events.add(event1);

//        działa - spr konwertera json
//        System.out.println(FileService.toJson(user1));
//        System.out.println(FileService.toJson(route1));
//        System.out.println(FileService.toJson(event1));
//
//        dziala
//        System.out.println(FileService.toJson(Users.getUserArrayList()));

//        Sprawdzenie czy sciezka działa - działa
//        System.out.println(FileService.getPathUsersFile().toString());

//       FileService.writeObjectToJsonFile(Users.getUserArrayList(), FileService.getPathUsersFile());
//       FileService.writeObjectToJsonFile(Routes.getRouteArrayList(), FileService.getPathRoutesFile());
//       FileService.writeObjectToJsonFile(Events.getEventArrayList(), FileService.getPathEventsFile());

         Users users = FileService.readUsersFromFile();




    }



}