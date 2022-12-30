package org.infoshareacademy.javaholics.route;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RouteService {
    boolean status;
    Date date = new Date();
    Route route = new Route();

    public Date getDate() {
        return date;
    }

    Scanner scanner = new Scanner(System.in);

    public void routeLength() {
        boolean error = false;
        System.out.println("Podaj początek trasy : ");
        route.setPlaceStart(scanner.nextLine());
        System.out.println("Podaj koniec trasy : ");
        route.setPlaceStop(scanner.nextLine());
        System.out.println("Podaj długość trasy w km : ");
        do{
            error = false;
            try {
                route.setLength(scanner.nextDouble());
                while (route.getLength() < 0 || route.getLength() == 0) {
                    System.out.println("Podaj poprawną długośc trasy");
                    route.setLength(scanner.nextDouble());
                }
            }catch (InputMismatchException e) {
                System.out.println("Podaj poprawną długośc trasy");
                error = true;
                scanner.nextLine();}
        }while (error);
        System.out.println("Początek twojej trasy jest : " + route.getPlaceStart() + " , a koniec jest " + route.getPlaceStop());
        System.out.println("Całkowita długość trasy to " + route.getLength() + " km");
    }

    public void routeLevelOfDifficulty() {
        boolean error = false;
        System.out.println("Podaj poziom trudności trasy :");
        System.out.println("1 - Łatwy");
        System.out.println("2 - Średni");
        System.out.println("3 - Wymagający");
        System.out.println("4 - Bardzo trudny");
        int levelOfDifficulty;
        do{
            error = false;
            try {
                levelOfDifficulty = scanner.nextInt();
                while (levelOfDifficulty != 1 && levelOfDifficulty != 2 && levelOfDifficulty != 3 && levelOfDifficulty != 4) {
                    System.out.println("Wybierz poprawny poziom trudności");
                    levelOfDifficulty = scanner.nextInt();
                }
                if (levelOfDifficulty == 1) {
                    System.out.println("Poziom trasy - Łatwy");
                    route.setDifficulty(RouteDifficulty.EASY);
                }
                if (levelOfDifficulty == 2) {
                    System.out.println("Poziom trasy - Średni");
                    route.setDifficulty(RouteDifficulty.MEDIUM);
                }
                if (levelOfDifficulty == 3) {
                    System.out.println("Poziom trasy - Wymagający");
                    route.setDifficulty(RouteDifficulty.EXTREME);
                }
                if (levelOfDifficulty == 4) {
                    System.out.println("Poziom trasy - Bardzo trudny");
                    route.setDifficulty(RouteDifficulty.HARD);
                }
            } catch (InputMismatchException e) {
                System.out.println("Wybierz poprawny poziom trudności trasy");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        System.out.println("Proponowany poziom trudności stworzonej trasy to " + route.getDifficulty());
    }


    public void routeType (){
        System.out.println("Podaj typ trasy :  ");
        System.out.println("1 - Trasa spacerowa ");
        System.out.println("2 - Trasa rowerowa ");
        System.out.println("3 - Trasa trekingowa ");
        int typeRoute;
        boolean error = false;
        do {
            error = false;
            try {
                typeRoute = scanner.nextInt();
                while (typeRoute != 1 && typeRoute != 2 && typeRoute != 3) {
                    System.out.println("Wybierz poprawny poziom trudności");
                    typeRoute = scanner.nextInt();
                }
                if (typeRoute == 1) {
                    System.out.println("Typ trasy - Trasa spacerowa");
                    route.setType("Trasa spacerowa");
                }
                if (typeRoute == 2) {
                    System.out.println("Typ trasy - Trasa rowerowa");
                    route.setType("Trasa rowerowa");
                }
                if (typeRoute == 3) {
                    System.out.println("Typ trasy - Trasa trekingowa");
                    route.setType("Trasa trekingowa");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wybierz poprawny typ trasy");
                error = true;
                scanner.nextLine();
            }
        }while (error) ;
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
    public void summaryRoute(){
        System.out.println("///////////////////////////////////////////");
        System.out.println("Podsumowanie stworzonej trasy : ");
        System.out.println("Trasa rozpoczyna się w miejscowości : " + route.getLocality());
        System.out.println("Trasa rozpoczyna się w punkcie : " + route.getPlaceStart());
        System.out.println("Trasa kończy się w punkcie : " + route.getPlaceStop());
        System.out.println("Długość trasy to : " + route.getLength() + " km");
        System.out.println("Typ trasy to : " + route.getType());
        System.out.println("Poziom trudności trasy to : " + route.getDifficulty());
        System.out.println("Data i godzina zapisania trasy : " + getDate());
        System.out.println("///////////////////////////////////////////");
    }
    public void routCre(){
        routeArea();
        routeLength();
        routeType();
        routeLevelOfDifficulty();
        routeDate();
        summaryRoute();
    }
}
