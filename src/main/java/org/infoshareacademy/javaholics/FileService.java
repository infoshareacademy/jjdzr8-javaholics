package org.infoshareacademy.javaholics;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




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
            System.out.println("Zapisano w: " + pathToSave.toString());
        } catch (NoSuchFileException ex){
            System.out.println("Brak pliku docelowego: " + ex.getMessage());
        } catch (IOException ex){
            System.out.println("Błąd zapisu: " + ex.getMessage());
        }

    }

    public static TestObject readTestFromFile(Path pathToRead){
        try (Reader reader = new FileReader(pathToRead.toString())) {
            System.out.println("Zczytuje plik: " + pathToRead.toString());
            TestObject test = gson.fromJson(reader, TestObject.class);
            return test;
        } catch (IOException e) {
            System.out.println("Pli nieznaleziony lub uszkodzony: " + e.getMessage());
            return new TestObject("test", "test", "test", 11L);
        }
    }
}
