package org.infoshareacademy.javaholics;
import org.infoshareacademy.javaholics.route.RouteService;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    public void printMenu() {
        System.out.println("1. Dodaj nową trasę");
        System.out.println("2. Wyszukaj trasę");
        System.out.println("3. Edytuj trasę");
        System.out.println("4. Usuń trasę");
        System.out.println("5. Dodaj Event");
        System.out.println("6. Wyszukaj Event");

        //InputMechanics input = new InputMechanics();
        //System.out.print("Co chcesz zrobić - podaj z klawiatury odpwiednią cyfrę: ");
        //input.getInputSwitch(6); - ta metoda wsadzona do switcha uproszczonego /bez wyjatków, sprawdzę is wrong answer itp



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
                        break;
                    case 3:
                        System.out.println("Edytuj trasę");
                        break;
                    case 4:
                        System.out.println("Usuń trasę");
                        break;
                    case 5:
                        System.out.println("Dodaj Event");
                        break;
                    case 6:
                        System.out.println("Wyszukaj Event");
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
