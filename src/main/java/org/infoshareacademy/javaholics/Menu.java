package org.infoshareacademy.javaholics;

import java.awt.print.Printable;
import java.util.Scanner;

public class Menu {

    public void printMenu() {
        boolean isWrongAnswer;
        Scanner scanner = new Scanner(System.in);

        do {
            isWrongAnswer = false;
            System.out.print("Co chcesz zrobić: ");
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
        } while (isWrongAnswer);
    }
}

