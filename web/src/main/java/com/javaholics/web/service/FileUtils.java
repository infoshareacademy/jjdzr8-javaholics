package com.javaholics.web.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javaholics.web.repository.IDsNumbers;


import java.io.*;

public class FileUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String IDS_JSON_FILE = "web/src/main/java/com/javaholics/web/database/IdNumbers.json";

    public void saveIdsToJsonFile(IDsNumbers ipsNumbers) {
        try (Writer writer = new FileWriter(IDS_JSON_FILE)) {
            GSON.toJson(ipsNumbers, writer);
            System.out.println("IDs' saved to json file:  " + IDS_JSON_FILE);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public IDsNumbers readIdsFromJsonFile() {
        try (Reader reader = new FileReader(IDS_JSON_FILE)) {
            System.out.println("Reading IDs' from json file: " + IDS_JSON_FILE);
            IDsNumbers ipsNumbers = GSON.fromJson(reader, IDsNumbers.class);
            System.out.println("IPs' successfully uploaded. Number of IDs': " + ipsNumbers);
            return ipsNumbers;
        } catch (IOException e) {
            System.out.println("IDs' json file not found or broken: " + e.getMessage());
            return new IDsNumbers();
        }
    }
}
