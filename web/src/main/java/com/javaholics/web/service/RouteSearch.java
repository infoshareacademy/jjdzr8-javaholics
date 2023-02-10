package com.javaholics.web.service;

import com.google.gson.reflect.TypeToken;
import org.infoshareacademy.javaholics.Menu;
import org.infoshareacademy.javaholics.utils.FileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class RouteSearch {

    Scanner scanner = new Scanner(System.in);
    FileService fileService = new FileService();

    public void displayRoutePlaceAndDifficulty() {
        Routes routes = new Routes();
        routes = fileService.readRoutesFromFile();
        Map<String, Map<String, List<Route>>> regionAndPlaceMap = new TreeMap<>();

        for (int i = 0; i < routes.getRoutes().size(); i++) {
            String keyLocality = routes.getRoutes().get(i).getLocality();
            String keyType = String.valueOf(routes.getRoutes().get(i).getType());

            if (!regionAndPlaceMap.containsKey(keyLocality)) {
                regionAndPlaceMap.put(keyLocality, new TreeMap<>());
                regionAndPlaceMap.get(keyLocality).put(keyType, new ArrayList<>());
                regionAndPlaceMap.get(keyLocality).get(keyType).add(routes.getRoutes().get(i));
            } else {
                if (!regionAndPlaceMap.get(keyLocality).containsKey(keyType)) {
                    regionAndPlaceMap.get(keyLocality).put(keyType, new ArrayList<>());
                    regionAndPlaceMap.get(keyLocality).get(keyType).add(routes.getRoutes().get(i));
                } else {
                    regionAndPlaceMap.get(keyLocality).get(keyType).add(routes.getRoutes().get(i));
                }

            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj region wyszukiwania");

        System.out.println(regionAndPlaceMap.keySet());

        String region;

        do {
            System.out.println("Wpisz właściwy region !");
            region = scanner.nextLine();
        } while (!regionAndPlaceMap.containsKey(region));

        System.out.println("Jest " + regionAndPlaceMap.get(region).size() + " miejscowości w tym regionie !");
        System.out.println(regionAndPlaceMap.get(region).keySet());
        String difficulty;

        do {
            System.out.println("Wpisz właściwy tryp aktywnośći !");
            difficulty = scanner.nextLine();
        } while (!regionAndPlaceMap.get(region).containsKey(difficulty));
        for (int i = 0; i < regionAndPlaceMap.get(region).get(difficulty).size(); i++) {
            System.out.println(regionAndPlaceMap.get(region).get(difficulty).get(i));
        }
        System.out.println("Wciśnij dowolny przycisk");
        menuReturn();
    }
    public void menuReturn(){
        scanner.nextLine();
        Menu menu = new Menu();
        menu.printMenu();
    }
}

