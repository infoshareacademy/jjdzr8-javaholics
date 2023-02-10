package com.javaholics.web.service;
import com.javaholics.web.repository.*;
import com.javaholics.web.service.*;
import com.javaholics.web.controller.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    public void printMenu() {
        System.out.println(Instructions.getLogo());
        System.out.println("1. Dodaj nową trasę");
        System.out.println("2. Wyszukaj trasę");
        System.out.println("3. Edytuj trasę");
        System.out.println("4. Dodaj Event");
        System.out.println("5. Edytuj Event");
        System.out.println("6. Wyszukaj Event");

        boolean isWrongAnswer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Co chcesz zrobić: ");

        RouteService routeService = new RouteService();
        EventService eventService = new EventService();
        RouteSearch routeSearch = new RouteSearch();


        do {
            isWrongAnswer = false;
            try {
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.println("Dodaj nową trasę");
                        routeService.routCre();
                    }
                    case 2 -> {
                        System.out.println("Wyszukaj trasę");
                        routeSearch.displayRoutePlaceAndDifficulty();
                    }
                    case 3 -> {
                        System.out.println("Edytuj trasę");
                        routeService.editRoute();
                    }
                    case 4 -> {
                        System.out.println("Dodaj Event");
                        eventService.startEvent();
                    }
                    case 5 -> {
                        System.out.println("Edytuj event");
                        eventService.editEvent();
                    }
                    case 6 -> {
                        System.out.println("Wyszukaj Event");
                        eventService.displaySortedEventsByRegionAndPalce();
                    }
                    default -> {
                        System.out.println("Wybierz opcję od 1 do 6");
                        isWrongAnswer = true;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.print("Wybierz proszę widoczne opcje powyżej.");
                isWrongAnswer = true;
                scanner.nextLine();
            }
        } while (isWrongAnswer);
    }
}
