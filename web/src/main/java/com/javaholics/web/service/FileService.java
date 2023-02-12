package com.javaholics.web.service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javaholics.web.repository.Event;
import com.javaholics.web.repository.Events;
import com.javaholics.web.repository.Routes;
import com.javaholics.web.repository.Users;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.Objects;

@Service
public class FileService {
    // definicja ścieżek do plików bazy
    private static final Path pathUsersFile = Path.of("database", "users.json");
    private static final Path pathEventsFile = Path.of("database", "events.json");
    private static final Path pathRoutesFile = Path.of("web","src","main","java","com","javaholics","web","database","routes.json");

    // gettery do ścieżek
    public static Path getPathUsersFile() {
        return pathUsersFile;
    }
    public static Path getPathEventsFile() {
        return pathEventsFile;
    }
    public static Path getPathRoutesFile() {
        return pathRoutesFile;
    }

    // inicjalizacja Gson
    public static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // metody zapisu
    public static String toJson(Object objectToJson){
        return gson.toJson(objectToJson);
    }
    public void addNewEventToDatabase(Event eventToAdd){
        Events eventsFromJson = readEventsFromFile();
        eventsFromJson.simpleAdd(eventToAdd);
        writeToJsonFile(eventsFromJson);
    }
//    public void addNewRouteToDatabase(Route routeToAdd){
//        Routes routesFromJson = readRoutesFromFile();
//
//        //routesFromJson.simpleAdd(routeToAdd);
//        writeToJsonFile(routesFromJson);
//    }

    public void writeToJsonFile(final Routes routes) {
        writeObjectToJsonFile(routes, pathRoutesFile);
    }
    public void writeToJsonFile(final Events events) {
        writeObjectToJsonFile(events, pathEventsFile);
    }
    public void writeObjectToJsonFile(Object objectToSave, Path pathToSave) {

        try (Writer writer = new FileWriter(pathToSave.toString())){
            gson.toJson(objectToSave, writer);
            System.out.println("Zapisano w: " + pathToSave);
        } catch (NoSuchFileException ex){
            System.out.println("Brak pliku docelowego: " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("Błąd zapisu: " + ex.getMessage());
        }

    }

    // metody czytania pliku
    private <T> T readDataFromJsonFile(Class<T> dataType, Path path) {
        try (Reader reader = new FileReader(path.toFile())) {
            System.out.println("Zaczytuję plik: " + path);
            return gson.fromJson(reader, dataType);
        } catch (IOException e) {
            System.out.println("Plik nieznaleziony lub uszkodzony: " + e.getMessage());
            return null;
        }
    }
    public Users readUsersFromFile() {
        Users users = readDataFromJsonFile(Users.class, pathUsersFile);
        if (Objects.nonNull(users)) {
            System.out.println("Plik właściwie zaimportowany. Ilość użytkowników: " + users.getUsers().size());
            return users;
        } else {
            return new Users();
        }
    }

    public Events readEventsFromFile() {
        Events events = readDataFromJsonFile(Events.class, pathEventsFile);
        if (Objects.nonNull(events)) {
            System.out.println("Plik właściwie zaimportowany. Ilość użytkowników: " + events.getEvents().size());
            return events;
        } else {
            return new Events();
        }
    }

    public Routes readRoutesFromFile() {
        Routes routes = readDataFromJsonFile(Routes.class, pathRoutesFile);
        if (Objects.nonNull(routes)) {
            System.out.println("Plik właściwie zaimportowany. Ilość użytkowników: " + routes.getRoutes().size());
            return routes;
        } else {
            return new Routes();
        }
    }
}
