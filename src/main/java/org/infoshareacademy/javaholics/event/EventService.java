package org.infoshareacademy.javaholics.event;

import org.infoshareacademy.javaholics.route.Route;
import org.infoshareacademy.javaholics.user.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EventService {

    User user = new User();
    Event event = new Event();
    Date date = new Date();


    public Date getDate() {
        return date;
    }

    Scanner scanner = new Scanner(System.in);
    public void eventDetails() {
        try {
            System.out.print("podaj miejsce eventu: ");
            event.setPlace(scanner.nextLine());
            System.out.print("podaj region eventu: ");
            event.setRegion(scanner.nextLine());
            System.out.print("Opis wydarzenia: ");
            event.setDescription(scanner.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("błąd walidacji");
            System.exit(0);
        }
        try {
            System.out.print("Ile będzie uczestników: ");
            event.setUsersCount(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Podaj poprawne dane, ile będzie uczestników.");
            System.exit(0);
        }

        System.out.println("Data eventu: " + getDate());

        event.setOwnerOfEvent();
        System.out.println("Nick oraz e-mail organizatora: " + event.getOwnerOfEvent() + " oraz garnki i pieczarki");
    }

}