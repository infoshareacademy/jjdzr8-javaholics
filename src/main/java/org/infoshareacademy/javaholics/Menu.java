package org.infoshareacademy.javaholics;
import org.infoshareacademy.javaholics.event.EventService;
//import org.infoshareacademy.javaholics.route.RouteSearch;
import org.infoshareacademy.javaholics.route.RouteSearch;
import org.infoshareacademy.javaholics.route.RouteService;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    public void printMenu() {
        System.out.println("1. Dodaj nową trasę");
        System.out.println("2. Wyszukaj trasę");
        System.out.println("3. Edytuj trasę");
        System.out.println("4. Dodaj Event");
        System.out.println("5. Edytuj Event");
        System.out.println("6. Wyszukaj Event");

        boolean isWrongAnswer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Co chcesz zrobić: ");

        do {
            isWrongAnswer = false;
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Dodaj nową trasę");
                        RouteService routeService = new RouteService();
                        routeService.routCre();
                        break;
                    case 2:
                        System.out.println("Wyszukaj trasę");
                        RouteSearch routeSearch = new RouteSearch();
                        routeSearch.displayRoutePlaceAndDifficulty();
                        break;
                    case 3:
                        System.out.println("Edytuj trasę");
                        RouteService routeService1 = new RouteService();
                        routeService1.editRoute();
                        break;
                    case 4:
                        System.out.println("Dodaj Event");
                        EventService eventService = new EventService();
                        eventService.startEvent();
                        break;
                    case 5:
                        System.out.println("Edytuj event");
                        EventService eventService3 = new EventService();
                        eventService3.editEvent();
                        break;
                    case 6:
                        System.out.println("Wyszukaj Event");
                        EventService eventService2 = new EventService();
                        eventService2.displaySortedEventsByRegionAndPalce();
                        break;
                    default:
                        System.out.println("Wybierz opcję od 1 do 6");
                        isWrongAnswer = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Wybierz proszę widoczne opcje powyżej.");
                isWrongAnswer = true;
                scanner.nextLine();
            }
        } while (isWrongAnswer);
    }
}
