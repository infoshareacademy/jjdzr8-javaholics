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

        boolean error = false;

        System.out.print("podaj miejsce eventu: ");
        event.setPlace(scanner.nextLine());
        System.out.print("podaj region eventu: ");
        event.setRegion(scanner.nextLine());
        System.out.print("Opis wydarzenia: ");
        event.setDescription(scanner.nextLine());
        System.out.print("Ile będzie uczestników: ");
        do {
            error = false;

            try {
                event.setUsersCount(scanner.nextInt());
                while (event.getUsersCount() < 0 || event.getUsersCount() == 0) {
                    System.out.print("Podaj poprawnie ile będzie uczestników: ");
                    event.setUsersCount(scanner.nextInt());
                }

            } catch (InputMismatchException e) {
                System.out.print("Błędne dane, ile będzie uczestników: ");
                error = true;
                scanner.nextInt();
            }
        } while (error);


        System.out.println("Data eventu: " + getDate());

        event.setOwnerOfEvent();
        System.out.println("Nick oraz e-mail organizatora: " + event.getOwnerOfEvent() + " oraz garnki i pieczarki");
    }

}