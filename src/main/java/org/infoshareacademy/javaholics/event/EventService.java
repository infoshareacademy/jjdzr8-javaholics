package org.infoshareacademy.javaholics.event;

import com.google.gson.JsonObject;
import org.infoshareacademy.javaholics.IdNumbers;
import org.infoshareacademy.javaholics.user.User;
import org.infoshareacademy.javaholics.user.Users;
import org.infoshareacademy.javaholics.utils.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import static org.infoshareacademy.javaholics.utils.FileService.gson;

public class EventService implements IdNumbers {

//trasa początek i koniec
//data i godzina rozpoczęcia
//ilośc uczestników
//nick i mail organizatora

    Users user = new Users();
    InputMechanics input = new InputMechanics();
    User user1 = new User(111L, "Jan1", "login1");
    Event newEvent;
    Date date = new Date();
    Scanner scanner = new Scanner(System.in);

    public Date getDate() {
        return date;
    }

    public void eventInitializeStart() {
        long id = 111L;
        System.out.println(Instructions.getSeparator());
        System.out.println("Podaj nazwę eventu: ");
        String nameFromScanner = input.getInputShort();

        newEvent = new Event(nameFromScanner, id, new Date(2022 - 12 - 29), "17:00", user1);

        System.out.println("Wprowadzone parametry eventu: ");
        System.out.println("Nazwa eventu : " + newEvent.getEventName());
        System.out.println("Id eventu : " + newEvent.getId());
        System.out.println("Data eventu : " + newEvent.getDate());
        System.out.println("Godzina rozpoczęcia eventu : " + newEvent.getTime());
    }
    public void eventInitializeEdit() {
        boolean error = false;
        long id = 0;
        do {
            error = false;
            try {
                System.out.print("Podaj numer Id eventu: ");
                id = Long.parseLong(scanner.nextLine());
                while (id < 0 || id == 0) {
                    System.out.println("Podaj poprawną wartość");
                    id = Long.parseLong(scanner.nextLine());
                }
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawny numer ID:");
                error = true;
                scanner.nextLine();
            }
        } while (error);
        System.out.println(Instructions.getSeparator());
        System.out.println("Podaj nazwę eventu: ");
        String nameFromScanner = input.getInputShort();

        newEvent = new Event(nameFromScanner, id, new Date(2022 - 12 - 29), "17:00", user1);

        System.out.println("Wprowadzone parametry eventu: ");
        System.out.println("Nazwa eventu : " + newEvent.getEventName());
        System.out.println("Id eventu : " + newEvent.getId());
        System.out.println("Data eventu : " + newEvent.getDate());
        System.out.println("Godzina rozpoczęcia eventu : " + newEvent.getTime());
    }

    public void eventDetails() {
        boolean error = false;
        System.out.print("podaj miejsce eventu: ");
        newEvent.setPlace(scanner.nextLine());
        System.out.print("podaj region eventu: ");
        newEvent.setRegion(scanner.nextLine());
        System.out.print("Opis wydarzenia: ");
        newEvent.setDescription(scanner.nextLine());
        do {
            error = false;
            try {
                System.out.print("Ile będzie uczestników: ");
                newEvent.setUsersCount(scanner.nextInt());
                while (newEvent.getUsersCount() < 0 || newEvent.getUsersCount() == 0) {
                    System.out.println("Podaj poprawną wartość");
                    newEvent.setUsersCount(scanner.nextInt());
                }
            } catch (InputMismatchException e) {
                System.out.println("Podaj poprawne dane, ile będzie uczestników.");
                error = true;
                scanner.nextLine();
            }
        } while (error);

        System.out.println("Data eventu: " + getDate());
        newEvent.setOwnerOfEvent(user1);
        System.out.println("Nick oraz e-mail organizatora: " + newEvent.getOwnerOfEvent() + " oraz garnki i pieczarki");
    }

    public void saveEvent() {
        FileService fileService = new FileService();
        fileService.addNewEventToDatabase(newEvent);
    }

    public void startEvent() {
        eventInitializeStart();
        eventDetails();
        saveEvent();
    }
    public void editEvent(){
        FileService fileService = new FileService();
        try {
            Events events = new Events();
            events = fileService.readEventsFromFile();
            BufferedReader br = new BufferedReader(new FileReader("database/events.json"));
            JsonObject jsonObject = gson.fromJson(br, JsonObject.class);
            String stringResponse = jsonObject.get("events").toString();
            System.out.println(stringResponse);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        eventInitializeEdit();
        eventDetails();
        saveEvent();
    }

    public long getCurrentIpNoSaveToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIpsFromJsonFile();
        return iDsNumbers.getIpEvent();
    }

    public long getCurrentIpWithSaveNextIpToJson() {
        IDsNumbers iDsNumbers = new IDsNumbers();
        FileUtils fileUtils = new FileUtils();
        iDsNumbers = fileUtils.readIpsFromJsonFile();
        long idEvent = iDsNumbers.getIpEvent();
        iDsNumbers.setIpEvent(idEvent + 1);
        fileUtils.saveIpsToJsonFile(iDsNumbers);
        return idEvent;
    }

    public void displaySortedEventsByRegionAndPalce() {
        Events events = new Events();
        FileService fileService = new FileService();
        events = fileService.readEventsFromFile();
        Map<String, Map<String, List<Event>>> regionAndPlaceMap = new TreeMap<>();
        List<Event> onlyPlaces = new ArrayList<>();
        Iterator<Map.Entry<Long, Event>> event = events.getEvents().entrySet().iterator();
        while (event.hasNext()) {
            Map.Entry<Long, Event> pair = event.next();
            String keyRegion = pair.getValue().getRegion();
            String keyPlace = pair.getValue().getPlace();

            onlyPlaces.add(pair.getValue());

            if (!regionAndPlaceMap.containsKey(keyRegion)) {
                regionAndPlaceMap.put(keyRegion, new TreeMap<>());
                regionAndPlaceMap.get(keyRegion).put(keyPlace, new ArrayList<>());
                regionAndPlaceMap.get(keyRegion).get(keyPlace).add(pair.getValue());
            } else {
                if (!regionAndPlaceMap.get(keyRegion).containsKey(keyPlace)) {
                    regionAndPlaceMap.get(keyRegion).put(keyPlace, new ArrayList<>());
                    regionAndPlaceMap.get(keyRegion).get(keyPlace).add(pair.getValue());
                } else {
                    regionAndPlaceMap.get(keyRegion).get(keyPlace).add(pair.getValue());
                }
            }

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj region wyszukiwania");

        System.out.println(regionAndPlaceMap.keySet());

        String region;
        Boolean allPlaces = false;

        do {
            System.out.println("Wpisz właściwy region lub *, aby wszystkie lokalizacje !");
            region = scanner.nextLine();
        } while (!(regionAndPlaceMap.containsKey(region) || (region.equals("*"))));
        if (!region.equals("*")) {
            System.out.println("Jest " + regionAndPlaceMap.get(region).size() + " miejscowości w tym regionie !");

            System.out.println(regionAndPlaceMap.get(region).keySet());

        } else {
            allPlaces = true;

        }
        String place = "";

        if (!allPlaces) {
            do {
                System.out.println("Wpisz właściwą miejscowość lub *, aby wszystkie z danego regionu!");
                place = scanner.nextLine();
            } while (!(regionAndPlaceMap.get(region).containsKey(place) || (place.equals("*"))));
        }
        if (place.equals("*")) {
            allPlaces=true;
            onlyPlaces.clear();
            Iterator<String> itr = regionAndPlaceMap.get(region).keySet().iterator();
            while (itr.hasNext()) {
                String key = itr.next();
                for (int i = 0; i < regionAndPlaceMap.get(region).get(key).size(); i++) {
                    onlyPlaces.add(regionAndPlaceMap.get(region).get(key).get(i));
                }
            }
        }
        int arraySize;
        int sizeLoop;
        if (!allPlaces) {
            arraySize = regionAndPlaceMap.get(region).get(place).size();
            sizeLoop = regionAndPlaceMap.get(region).get(place).size();
        } else {
            arraySize = onlyPlaces.size();
            sizeLoop = arraySize;
        }
        Event[] preSortedEvents = new Event[arraySize];
        for (int i = 0; i < sizeLoop; i++) {
            if ((allPlaces)) {
                preSortedEvents[i] = onlyPlaces.get(i);
            } else {
                preSortedEvents[i] = regionAndPlaceMap.get(region).get(place).get(i);
            }
        }
        Event[] sortedEvents = new Event[arraySize];
        sortedEvents = sortArrayEvent(preSortedEvents);

        for (int i = 0; i < sortedEvents.length; i++) {
            System.out.println(sortedEvents[i]);
        }
    }

    public Event[] sortArrayEvent(Event[] event) {
        Event temp;
        for (int j = 0; j < event.length; j++) {

            for (int i = 0; i < event.length - 1; i++) {

                if (event[i].getDate().compareTo(event[i + 1].getDate()) > 0) {
                    temp = event[i + 1];
                    event[i + 1] = event[i];
                    event[i] = temp;
                }
            }
        }
        return event;
    }
}
