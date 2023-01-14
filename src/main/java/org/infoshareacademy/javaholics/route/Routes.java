package org.infoshareacademy.javaholics.route;

import java.util.ArrayList;
import java.util.List;

public class Routes {
    private List<Route> routes = new ArrayList<>();

    public List<Route> getRoutes() {
        return routes;
    }

    public void setUserArrayList(List<Route> userArrayList) {
        this.routes = userArrayList;
    }

    public void add(Route route) {
        routes.add(route);
        System.out.println("Nowa trasa dodana: " + route.toString());
    }
}
//    FileService fileService = new FileService();
//
//    public void displayEventsRegionAndPlace() {
//
//        Events events = new Events();
//        events = fileService.readEventsFromFile();
//        Map<String, Map<String, List<Event>>> regionAndPlaceMap = new TreeMap<>();
//
//        for (int i = 0; i < events.getEvents().size(); i++) {
//            String keyRegion = events.getEvents().get(i).getRegion();
//            String keyPlace = events.getEvents().get(i).getPlace();
//
//            if (!regionAndPlaceMap.containsKey(keyRegion)) {
//                regionAndPlaceMap.put(keyRegion, new TreeMap<>());
//                regionAndPlaceMap.get(keyRegion).put(keyPlace, new ArrayList<>());
//                regionAndPlaceMap.get(keyRegion).get(keyPlace).add(events.getEvents().get(i));
//            } else {
//                if (!regionAndPlaceMap.get(keyRegion).containsKey(keyPlace)) {
//                    regionAndPlaceMap.get(keyRegion).put(keyPlace, new ArrayList<>());
//                    regionAndPlaceMap.get(keyRegion).get(keyPlace).add(events.getEvents().get(i));
//                } else {
//                    regionAndPlaceMap.get(keyRegion).get(keyPlace).add(events.getEvents().get(i));
//                }
//            }
//
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj region wyszukiwania");
//
//        System.out.println(regionAndPlaceMap.keySet());
//
//        String region;
//
//        do {
//            System.out.println("Wpisz właściwy region !");
//            region = scanner.nextLine();
//        } while (!regionAndPlaceMap.containsKey(region));
//
//        System.out.println("Jest " + regionAndPlaceMap.get(region).size() + " miejscowości w tym regionie !");
//
//        System.out.println(regionAndPlaceMap.get(region).keySet());
//        String place;
//
//        do {
//            System.out.println("Wpisz właściwą miejscowość !");
//            place = scanner.nextLine();
//        } while (!regionAndPlaceMap.get(region).containsKey(place));
//
//        for (int i = 0; i < regionAndPlaceMap.get(region).get(place).size(); i++) {
//            System.out.println(regionAndPlaceMap.get(region).get(place).get(i));
//        }
//
//
//    }
//
//}
