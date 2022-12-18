package org.infoshareacademy.javaholics.AllRoute;
import org.infoshareacademy.javaholics.Route;
import org.infoshareacademy.javaholics.RouteDifficulty;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Date;

public class CreateRoute {
    boolean status;
    Date date = new Date();
    Route route = new Route();
    public Date getDate() {
        return date;
    }

    Scanner scanner = new Scanner(System.in);
    public void routeLength (){
        System.out.println("Podaj początek trasy : ");
        route.setPlaceStart(scanner.nextLine());
        System.out.println("Podaj koniec trasy : ");
        route.setPlaceStop(scanner.nextLine());
        System.out.println("Podaj długość trasy w km : ");
        route.setLength(scanner.nextInt());
        System.out.println("Początek twojej trasy jest : " + route.getPlaceStart() + " , a koniec jest " + route.getPlaceStop());
        System.out.println("Całkowita długość trasy to " + route.getLength());

    }
    public void routeLevelOfDifficulty (){
        System.out.println("Podaj poziom trudności trasy :");
        System.out.println("1 - Łatwy");
        System.out.println("2 - Średni");
        System.out.println("3 - Wymagający");
        System.out.println("4 - Bardzo trudny");
        int levelOfDifficulty = scanner.nextInt();
        if (levelOfDifficulty == 1){
            System.out.println("Poziom trasy - Łatwy");
            route.setDifficulty(RouteDifficulty.EASY);
        }
        if (levelOfDifficulty == 2){
            System.out.println("Poziom trasy - Średni");
            route.setDifficulty(RouteDifficulty.MEDIUM);
        }
        if (levelOfDifficulty == 3){
            System.out.println("Poziom trasy - Wymagający");
            route.setDifficulty(RouteDifficulty.EXTREME);
        }
        if (levelOfDifficulty == 4){
            System.out.println("Poziom trasy - Bardzo trudny");
            route.setDifficulty(RouteDifficulty.HARD);
        }
        System.out.println("Proponowany poziom trudności stworzonej trasy to " + route.getDifficulty());
    }
    public void routeType (){
        System.out.println("Podaj typ trasy :  ");
        System.out.println("1 - Trasa spacerowa ");
        System.out.println("2 - Trasa rowerowa ");
        System.out.println("3 - Trasa trekingowa ");
        int typeRoute = scanner.nextInt();
        if (typeRoute == 1){
            System.out.println("Typ trasy - Trasa spacerowa");
            route.setType("Trasa spacerowa");
        }
        if (typeRoute == 2){
            System.out.println("Typ trasy - Trasa rowerowa");
            route.setType("Trasa rowerowa");
        }
        if (typeRoute == 3){
            System.out.println("Typ trasy - Trasa trekingowa");
            route.setType("Trasa trekingowa");
        }
        System.out.println(route.getType());
    }
    public void routeArea () {
        System.out.println("W jakiej miejscowości chcesz zacząć? ");
        route.setLocality(scanner.nextLine());
        System.out.println("Trasa ma lokalizację w miejscu : ");
        System.out.println(route.getLocality());
    }
    public void routeDate () {
        System.out.println(getDate());
        }
    public void routCre(){
        routeArea();
        routeLength();
        routeType();
        routeLevelOfDifficulty();
        routeDate();


    }
}


