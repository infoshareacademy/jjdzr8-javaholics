package org.infoshareacademy.javaholics.event;

import org.infoshareacademy.javaholics.route.Route;
import org.infoshareacademy.javaholics.route.Routes;
import org.infoshareacademy.javaholics.user.User;
import org.infoshareacademy.javaholics.user.Users;
import org.infoshareacademy.javaholics.utils.FileService;
import org.infoshareacademy.javaholics.utils.InputMechanics;
import org.infoshareacademy.javaholics.utils.Instructions;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.util.Calendar.AM;

public class EventService {

//trasa początek i koniec
//data i godzina rozpoczęcia
//ilośc uczestników
//nick i mail organizatora

    Users user = new Users();
    InputMechanics input = new InputMechanics();
    User user1 = new User(111L, "Jan1", "login1");
    Event newEvent;
    Date date = new Date();
    Scanner scanner = new Scanner(System.in);

    public Date getDate() {
        return date;
    }
    public void eventInitialize() {
        long id = 111L;
        System.out.println(Instructions.getSeparator());
        System.out.println("Podaj nazwę eventu: ");
        String nameFromScanner = input.getInputShort();

        newEvent = new Event(nameFromScanner, id, new Date(2022 - 12 - 29), "17:00", user1);

        System.out.println("Wprowadzone parametry eventu: ");
        System.out.println("Nazwa eventu : " + newEvent.getEventName());
        System.out.println("Id eventu : " + newEvent.getId());
        System.out.println("Data eventu : " + newEvent.getDate());
        System.out.println("Godzina rozpoczęcia eventu : " + newEvent.getTime());
    }

    public void eventDetails() {
        boolean error = false;
            System.out.print("podaj miejsce eventu: ");
            newEvent.setPlace(scanner.nextLine());
            System.out.print("podaj region eventu: ");
            newEvent.setRegion(scanner.nextLine());
            System.out.print("Opis wydarzenia: ");
            newEvent.setDescription(scanner.nextLine());
        do {
            error = false;
            try {
                System.out.print("Ile będzie uczestników: ");
                newEvent.setUsersCount(scanner.nextInt());
                while (newEvent.getUsersCount() < 0 || newEvent.getUsersCount() == 0 ){
                    System.out.println("Podaj poprawną wartość");
                    newEvent.setUsersCount(scanner.nextInt());
                }
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawne dane, ile będzie uczestników.");
                error = true;
                scanner.nextLine();
            }
        }while (error) ;

        System.out.println("Data eventu: " + getDate());
        newEvent.setOwnerOfEvent(user1);
        System.out.println("Nick oraz e-mail organizatora: " + newEvent.getOwnerOfEvent() + " oraz garnki i pieczarki");
    }
    public void saveEvent(){
        FileService fileService = new FileService();
        Events events = new Events();
        events.add(newEvent);
        fileService.writeToJsonFile(events);
    }
    public void startEvent(){
        eventInitialize();
        eventDetails();
        saveEvent();
    }
    }
