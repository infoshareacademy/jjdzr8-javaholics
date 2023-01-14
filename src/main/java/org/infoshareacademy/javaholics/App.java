package org.infoshareacademy.javaholics;


import org.infoshareacademy.javaholics.event.EventService;
import org.infoshareacademy.javaholics.event.Events;
//import org.infoshareacademy.javaholics.route.RouteSearch;
import org.infoshareacademy.javaholics.route.RouteService;
import org.infoshareacademy.javaholics.user.UserService;
import org.infoshareacademy.javaholics.utils.FileService;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.printMenu();
    }
}