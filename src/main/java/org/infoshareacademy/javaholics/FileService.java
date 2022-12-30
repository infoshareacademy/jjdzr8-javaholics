package org.infoshareacademy.javaholics;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.infoshareacademy.javaholics.event.Events;
import org.infoshareacademy.javaholics.route.Routes;
import org.infoshareacademy.javaholics.user.Users;


abstract class FileService {

    private static final Path pathUsersFile = Path.of("database", "users.json");
    private static final Path pathEventsFile = Path.of("database", "events.json");
    private static final Path pathRoutesFile = Path.of("database", "routes.json");


    public static Path getPathUsersFile() {
        return pathUsersFile;
    }
    public static Path getPathEventsFile() {
        return pathEventsFile;
    }
    public static Path getPathRoutesFile() {
        return pathRoutesFile;
    }

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static String toJson(Object objectToJson){
        return gson.toJson(objectToJson);
    }

    public static void writeObjectToJsonFile(Object objectToSave, Path pathToSave) {

        try (Writer writer = new FileWriter(pathToSave.toString())){
            gson.toJson(objectToSave, writer);
            System.out.println("Zapisano w: " + pathToSave);
        } catch (NoSuchFileException ex){
            System.out.println("Brak pliku docelowego: " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("Błąd zapisu: " + ex.getMessage());
        }

    }

     public static Users readUsersFromFile() {
        try (Reader reader = new FileReader(pathUsersFile.toString())) {
            System.out.println("Zczytuję plik: " + pathUsersFile);
            Users users = gson.fromJson(reader, Users.class);
            System.out.println("Plik właściwie zaimportowany. Ilość użytkowników: " + users.getUsers().size());
            return users;
        } catch (IOException e) {
            System.out.println("Plik nieznaleziony lub uszkodzony: " + e.getMessage());
            return new Users();
        }
    }

    public static Events readEventsFromFile() {
        try (Reader reader = new FileReader(pathEventsFile.toString())) {
            System.out.println("Zczytuję plik: " + pathEventsFile);
            Events events= gson.fromJson(reader, Events.class);
            System.out.println("Plik właściwie zaimportowany. Ilość eventów: " + events.getEvents().size());
            return events;
        } catch (IOException e) {
            System.out.println("Plik nieznaleziony lub uszkodzony: " + e.getMessage());
            return new Events();
        }
    }

    public static Routes readRoutessFromFile() {
        try (Reader reader = new FileReader(pathRoutesFile.toString())) {
            System.out.println("Zczytuję plik: " + pathRoutesFile);
            Routes routes= gson.fromJson(reader, Routes.class);
            System.out.println("Plik właściwie zaimportowany. Ilość eventów: " + routes.getRoutes().size());
            return routes;
        } catch (IOException e) {
            System.out.println("Plik nieznaleziony lub uszkodzony: " + e.getMessage());
            return new Routes();
        }
    }
}
