package org.infoshareacademy.javaholics.route;

import org.infoshareacademy.javaholics.utils.FileService;
import org.infoshareacademy.javaholics.utils.InputMechanics;
import org.infoshareacademy.javaholics.utils.Instructions;

import java.util.Date;
import java.util.InputMismatchException;

public class RouteFactory {

    Route newRoute;

    Date date = new Date();

    InputMechanics input = new InputMechanics();

    public void addRoute(){
        routeInitialize();
        routeArea();
        routeLength();

        summaryRoute();
        saveRoute();
    }

    public void routeInitialize(){
        // tu do poprawienia by id bylo dynamicznie nadawane i kolejno od ostaniego
        long id = 111L;
        System.out.println(Instructions.getSeparator());
        System.out.println("Podaj nazwę trasy: ");
        String nameFromScanner = input.getInputShort();

        newRoute = new Route(id, nameFromScanner);1

        System.out.println("Wprowadzona nazwa:");
        System.out.println(newRoute.getName());


    }

    public void routeArea () {
        System.out.println("W jakiej miejscowości chcesz zacząć? ");
        newRoute.setLocality(input.getInputShort());
        System.out.println("Trasa ma lokalizację w miejscu : ");
        System.out.println(newRoute.getLocality());
    }

    // Generator długości trasy
    public void routeLength() {
        boolean error = false;
        System.out.println("Podaj początek trasy : ");
        newRoute.setPlaceStart(input.getInputShort());
        System.out.println("Podaj koniec trasy : ");
        newRoute.setPlaceStop(input.getInputShort());
        System.out.println("Podaj długość trasy w km : ");
        newRoute.setLength(input.getInputNumber());
        System.out.println("Początek twojej trasy jest : " + newRoute.getPlaceStart() + " , a koniec jest " + newRoute.getPlaceStop());
        System.out.println("Całkowita długość trasy to " + newRoute.getLength() + " km");
    }

    public void summaryRoute(){
        System.out.println(Instructions.getSeparator());
        System.out.println("Podsumowanie stworzonej trasy : ");
        System.out.println("Trasa rozpoczyna się w miejscowości : " + newRoute.getLocality());
        System.out.println("Trasa rozpoczyna się w punkcie : " + newRoute.getPlaceStart());
        System.out.println("Trasa kończy się w punkcie : " + newRoute.getPlaceStop());
        System.out.println("Długość trasy to : " + newRoute.getLength() + " km");
        System.out.println("Typ trasy to : " + newRoute.getType());
        System.out.println("Poziom trudności trasy to : " + newRoute.getDifficulty());
        //System.out.println("Data i godzina zapisania trasy : " + getDate());
        System.out.println(Instructions.getSeparator());
    }

    //do przetestowania jaka kolekcja i czy nie musi być statyczna inicjalizowana na poaczatku programu
    public void saveRoute(){
        FileService fileService = new FileService();

        Routes routes = new Routes();
        routes.add(newRoute);
        fileService.writeToJsonFile(routes);
    }


}
