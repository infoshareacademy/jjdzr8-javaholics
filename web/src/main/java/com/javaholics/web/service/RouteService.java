package com.javaholics.web.service;

import com.google.gson.JsonObject;
import com.javaholics.web.controller.Menu;
import com.javaholics.web.repository.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javaholics.web.service.FileService.gson;

public class RouteService implements IdNumbers {
    boolean status;
    Route newRoute;
    Date date = new Date();
    InputMechanics input = new InputMechanics();
    Scanner scanner = new Scanner(System.in);
    public Date getDate() {
        newRoute.setDate(date);
        return date;
    }

    public void routeInitialize() {
        // tu do poprawienia by id bylo dynamicznie nadawane i kolejno od ostaniego
        getCurrentIdWithSaveNextIdToJson();
        long id = getCurrentIdNoSaveToJson();
        System.out.println(Instructions.getSeparator());
        System.out.print("Podaj nazwę trasy: ");
        String nameFromScanner = input.getInputShort();

        newRoute = new Route(id, nameFromScanner);

        System.out.println("Wprowadzona nazwa:");
        System.out.println(newRoute.getName());
    }
    public void routeInitializeEdit() {
        boolean error = false;
        long id = 0;
        do {
            error = false;
            try {
                System.out.print("Podaj numer Id trasy: ");
                id = Long.parseLong(scanner.nextLine());
                while (id < 0 || id == 0) {
                    System.out.print("Podaj poprawną wartość");
                    id = Long.parseLong(scanner.nextLine());
                }
            } catch (InputMismatchException e) {
                System.out.print("Podaj poprawny numer ID:");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        // tu do poprawienia by id bylo dynamicznie nadawane i kolejno od ostaniego
        System.out.println(Instructions.getSeparator());
        System.out.print("Podaj nazwę trasy: ");
        String nameFromScanner = input.getInputShort();

        newRoute = new Route(id, nameFromScanner);

        System.out.println("Wprowadzona nazwa:");
        System.out.println(newRoute.getName());
    }
    // Generator długości trasy
    public void routeLength() {
        boolean error = false;
        System.out.print("Podaj początek trasy : ");
        newRoute.setPlaceStart(input.getInputShort());
        System.out.print("Podaj koniec trasy : ");
        newRoute.setPlaceStop(input.getInputShort());
        System.out.print("Podaj długość trasy w km : ");
        newRoute.setLength(input.getInputNumber());
        System.out.print("Początek twojej trasy jest : " + newRoute.getPlaceStart() + " , a koniec jest " + newRoute.getPlaceStop());
        System.out.print("Całkowita długość trasy to " + newRoute.getLength() + " km");
    }
    // Generator poziomu trudnosci
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
                    newRoute.setDifficulty(RouteDifficulty.EASY);
                }
                if (levelOfDifficulty == 2) {
                    System.out.println("Poziom trasy - Średni");
                    newRoute.setDifficulty(RouteDifficulty.MEDIUM);
                }
                if (levelOfDifficulty == 3) {
                    System.out.println("Poziom trasy - Wymagający");
                    newRoute.setDifficulty(RouteDifficulty.EXTREME);
                }
                if (levelOfDifficulty == 4) {
                    System.out.println("Poziom trasy - Bardzo trudny");
                    newRoute.setDifficulty(RouteDifficulty.HARD);
                }
            } catch (InputMismatchException e) {
                System.out.print("Wybierz poprawny poziom trudności trasy");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        System.out.println("Proponowany poziom trudności stworzonej trasy to " + newRoute.getDifficulty());
    }

    // Generator
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
                    newRoute.setType("Trasa spacerowa");
                }
                if (typeRoute == 2) {
                    System.out.println("Typ trasy - Trasa rowerowa");
                    newRoute.setType("Trasa rowerowa");
                }
                if (typeRoute == 3) {
                    System.out.println("Typ trasy - Trasa trekingowa");
                    newRoute.setType("Trasa trekingowa");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wybierz poprawny typ trasy");
                error = true;
                scanner.nextLine();
            }
        }while (error) ;
        System.out.println(newRoute.getType());
    }

    public void routeArea () {
        System.out.print("W jakiej miejscowości chcesz zacząć? ");
        newRoute.setLocality(input.getInputShort());
        System.out.print("Trasa ma lokalizację w miejscu : ");
        System.out.print(newRoute.getLocality());
    }
    public void routeDate () {
        System.out.println(getDate());
    }
    public void summaryRoute(){
        System.out.println("----------------------------------------");
        System.out.println("Podsumowanie stworzonej trasy : ");
        System.out.println("Trasa rozpoczyna się w miejscowości : " + newRoute.getLocality());
        System.out.println("Trasa rozpoczyna się w punkcie : " + newRoute.getPlaceStart());
        System.out.println("Trasa kończy się w punkcie : " + newRoute.getPlaceStop());
        System.out.println("Długość trasy to : " + newRoute.getLength() + " km");
        System.out.println("Typ trasy to : " + newRoute.getType());
        System.out.println("Poziom trudności trasy to : " + newRoute.getDifficulty());
        System.out.println("Data i godzina zapisania trasy : " + getDate());
        System.out.println("///////////////////////////////////////////");
        System.out.println(Instructions.getSeparator());
    }
    public void menuReturn(){
        System.out.println("Wciśnij dowolny przycisk by wrócić do menu");
        scanner.nextLine();
        Menu menu = new Menu();
        menu.printMenu();
    }
    public void saveRoute(){
        FileService fileService = new FileService();

        Routes routes = new Routes();
        routes.add(newRoute);
        fileService.writeToJsonFile(routes);
    }

    public void routCre(){
        routeInitialize();
        routeArea();
        routeLength();
        routeType();
        routeLevelOfDifficulty();
        routeDate();
        summaryRoute();
        saveRoute();
        menuReturn();
    }
    public void editRoute(){
        FileService fileService = new FileService();
        try {
            Routes routes = new Routes();
            routes = fileService.readRoutesFromFile();
            BufferedReader br = new BufferedReader(new FileReader("database/routes.json"));
            JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
            String stringResponse = jsonObject.get("routes").toString();
            System.out.println(stringResponse);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        routeInitializeEdit();
        routeArea();
        routeLength();
        routeType();
        routeLevelOfDifficulty();
        routeDate();
        summaryRoute();
        saveRoute();
        menuReturn();
    }

    @Override
    public long getCurrentIdNoSaveToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        return iDsNumbers.getIpRoute();
    }

    @Override
    public long getCurrentIdWithSaveNextIdToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIdsFromJsonFile();
        long idRoute = iDsNumbers.getIpRoute();
        iDsNumbers.setIpRoute(idRoute+1);
        fileUtils.saveIdsToJsonFile(iDsNumbers);
        return idRoute;
    }
}