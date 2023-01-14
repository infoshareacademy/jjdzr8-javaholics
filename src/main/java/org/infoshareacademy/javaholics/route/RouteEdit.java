package org.infoshareacademy.javaholics.route;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.infoshareacademy.javaholics.utils.FileService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class RouteEdit {
    Gson gson = new Gson();
    FileService fileService = new FileService();
    public void editRoute(){
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
    }

}
