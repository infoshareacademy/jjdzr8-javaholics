package org.infoshareacademy.javaholics.route;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RouteSearch {
    public void routeSearch() {
        Gson gson = new Gson();
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader("database/routes.json"));
                JsonObject countruObj = gson.fromJson(br, JsonObject.class);
                String stringResponse = countruObj.get ("routes").toString();
                System.out.println(stringResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
