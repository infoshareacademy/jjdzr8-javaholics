package org.infoshareacademy.javaholics;


import org.infoshareacademy.javaholics.event.EventService;
import org.infoshareacademy.javaholics.event.Events;
import org.infoshareacademy.javaholics.route.RouteService;
import org.infoshareacademy.javaholics.user.UserService;
import org.infoshareacademy.javaholics.utils.FileService;

public class App {
    public static void main(String[] args) {
        EventService eventService = new EventService();
        RouteService routeService = new RouteService();
        routeService.routCre();
//        UserService userService = new UserService();
//        RouteService routeService = new RouteService();
////        eventService.startEvent();
//        System.out.println(eventService.getCurrentIpNoSaveToJson());
//        System.out.println(eventService.getCurrentIpWithSaveNextIpToJson());
//        System.out.println(userService.getCurrentIpWithSaveNextIpToJson());
//        System.out.println(routeService.getCurrentIpWithSaveNextIpToJson());

////      konstruktor obiektu rezygnacja z klasy abstrakcyjnej i metod statycznych
//
        FileService fileService = new FileService();
////      scenariusz testowy
//        // Users
//
//        Users users = new Users();
//        User user1 = new User(111L, "Jan1", "login1");
//        users.add(user1);
//        User user2 = new User(222L, "Jan2", "login2");
//        users.add(user2);
//
//        System.out.println(fileService.toJson(users));
//
//        // Zapis
//        fileService.writeJsonFile(users);
//
//        // Odczyt
//        Users usersFromJson = fileService.readUsersFromFile();
//
//        usersFromJson.getUsers().forEach(System.out::println);
//
//        // Routes
//        Routes routes = new Routes();
//        routes.add(new Route(111L, "trasa1"));
//        fileService.writeToJsonFile(routes);
//        Routes routesFromJson = fileService.readRoutesFromFile();
//        routesFromJson.getRoutes().forEach(System.out::println);
//
//        // Events
//        Events events = new Events();
//        events.add(new Event(111L, new Date(2022 - 12 - 29), "17", user1));
//        fileService.writeToJsonFile(events);
//        Events eventsFromJson = fileService.readEventsFromFile();
//        eventsFromJson.getEvents().forEach((k,v) -> System.out.println(k + " "+v));
        eventService.displaySortedEventsByRegionAndPalce();
//
//
//        IpsNumbers ipsNumbers = FileUtils.readUsersJsonFile();
//        ipsNumbers.setIpUser(2);
//        ipsNumbers.setIpRoute(2);
//        ipsNumbers.setIpEvent(3);
//        FileUtils.saveUsersToJsonFile(ipsNumbers);

    }



}