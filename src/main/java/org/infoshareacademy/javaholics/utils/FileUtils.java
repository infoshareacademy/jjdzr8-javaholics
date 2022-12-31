package org.infoshareacademy.javaholics.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.*;

public class FileUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String IDS_JSON_FILE = "src/main/resources/IdNumbers.json";

    public static void saveUsersToJsonFile(IpsNumbers ipsNumbers) {
        try (Writer writer = new FileWriter(IDS_JSON_FILE)) {
            GSON.toJson(ipsNumbers, writer);
            System.out.println("IDs' saved to json file:  " + IDS_JSON_FILE);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static IpsNumbers readUsersJsonFile() {
        try (Reader reader = new FileReader(IDS_JSON_FILE)) {
            System.out.println("Reading IDs' from json file: " + IDS_JSON_FILE);
            IpsNumbers ipsNumbers = GSON.fromJson(reader, IpsNumbers.class);
            System.out.println("IPs' successfully uploaded. Number of IDs': " + ipsNumbers);
            return ipsNumbers;
        } catch (IOException e) {
            System.out.println("IDs' json file not found or broken: " + e.getMessage());
            return new IpsNumbers();
        }
    }
}
