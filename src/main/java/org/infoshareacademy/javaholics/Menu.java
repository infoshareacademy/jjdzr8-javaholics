package org.infoshareacademy.javaholics;

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

        boolean isWrongAnswer;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Co chcesz zrobić: ");

        do {
            isWrongAnswer = false;
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Edycja");
                        break;
                    case 2:
                        System.out.println("Dodanie trasy");
                        break;
                    case 3:
                        System.out.println("Zapisanie trasy");
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
                break;
            }
        } while (isWrongAnswer);
    }
}

