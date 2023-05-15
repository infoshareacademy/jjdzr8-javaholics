//package com.javaholics.web.service;
//
//import com.javaholics.web.domain.Route;
//import com.javaholics.web.domain.RouteDifficulty;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//class RouteServiceTest {
//    RouteService routeService;
//    FileService fileService;
//        Route route1 = new Route(1, "Wycieczka rowerowa");
//        Route route2 = new Route(2, "Trip na miasto");
//        Route route3 = new Route(3, "Dla wytrzymałych");
//        Route route4 = new Route(4, "Kardio rowerowe");
//        Route route5 = new Route(5, "Szybka trasa zakupowa");
//
//
//
//    @Test
//    void getRoutesSearchLocalityEqualsWarszawa_shouldReturnSize1(){
//        //Given
//        route1.setType("Trasa rowerowa");
//        route1.setDifficulty(RouteDifficulty.EASY);
//        route1.setLocality("Wrocław");
//        route2.setType("Trasa trekingowa");
//        route2.setDifficulty(RouteDifficulty.HARD);
//        route2.setLocality("Zakopane");
//        route3.setType("Trasa wyczynowa");
//        route3.setDifficulty(RouteDifficulty.MEDIUM);
//        route3.setLocality("Warszawa");
//        route4.setType("Trasa rowerowa");
//        route4.setDifficulty(RouteDifficulty.EXTREME);
//        route4.setLocality("Kraków");
//        route5.setType("Trasa dla biegaczy");
//        route5.setDifficulty(RouteDifficulty.EASY);
//        route5.setLocality("Gdańsk");
//        List<Route> allRoutes = List.of(route1,route2,route3,route4,route5);
//        //When
//        List<Route> result = allRoutes.stream()
//                .filter(route -> StringUtils.containsIgnoreCase( route.getLocality(), "Warszawa"))
//                .collect(Collectors.toList() );
//        //Then
//        assertThat(result).hasSize(1);
//    }
//    @Test
//    void getRoutesSearchDificultyHARD_shouldReturn1(){
//        //Given
//        route1.setType("Trasa rowerowa");
//        route1.setDifficulty(RouteDifficulty.EASY);
//        route1.setLocality("Wrocław");
//        route2.setType("Trasa trekingowa");
//        route2.setDifficulty(RouteDifficulty.HARD);
//        route2.setLocality("Zakopane");
//        route3.setType("Trasa wyczynowa");
//        route3.setDifficulty(RouteDifficulty.MEDIUM);
//        route3.setLocality("Warszawa");
//        route4.setType("Trasa rowerowa");
//        route4.setDifficulty(RouteDifficulty.EXTREME);
//        route4.setLocality("Kraków");
//        route5.setType("Trasa dla biegaczy");
//        route5.setDifficulty(RouteDifficulty.EASY);
//        route5.setLocality("Gdańsk");
//        List<Route> allRoutes = List.of(route1,route2,route3,route4,route5);
//        //When
//        List<Route> result = allRoutes.stream()
//                .filter(route -> StringUtils.containsIgnoreCase( route.getDifficulty().name(), RouteDifficulty.HARD.toString()))
//                .collect(Collectors.toList() );
//        //Then
//        assertEquals("Zakopane", result.get(0).getLocality());
//    }
//    @Test
//    void getRoutesSearchTypeTrasaTrekingowa_shouldReturn1(){
//        //Given
//        route1.setType("Trasa rowerowa");
//        route1.setDifficulty(RouteDifficulty.EASY);
//        route1.setLocality("Wrocław");
//        route2.setType("Trasa trekingowa");
//        route2.setDifficulty(RouteDifficulty.HARD);
//        route2.setLocality("Zakopane");
//        route3.setType("Trasa wyczynowa");
//        route3.setDifficulty(RouteDifficulty.MEDIUM);
//        route3.setLocality("Warszawa");
//        route4.setType("Trasa rowerowa");
//        route4.setDifficulty(RouteDifficulty.EXTREME);
//        route4.setLocality("Kraków");
//        route5.setType("Trasa dla biegaczy");
//        route5.setDifficulty(RouteDifficulty.EASY);
//        route5.setLocality("Gdańsk");
//        List<Route> allRoutes = List.of(route1,route2,route3,route4,route5);
//        //When
//        List<Route> result = allRoutes.stream()
//                .filter(route -> StringUtils.containsIgnoreCase( route.getType(), "biega"))
//                .collect(Collectors.toList() );
//        //Then
//        assertEquals("Gdańsk", result.get(0).getLocality());
//    }
//    @Test
//    void getRoutesSearch3_shouldReturnNull(){
//        //Given
//        route1.setType("Trasa rowerowa");
//        route1.setDifficulty(RouteDifficulty.EASY);
//        route1.setLocality("Wrocław");
//        route2.setType("Trasa trekingowa");
//        route2.setDifficulty(RouteDifficulty.HARD);
//        route2.setLocality("Zakopane");
//        route3.setType("Trasa wyczynowa");
//        route3.setDifficulty(RouteDifficulty.MEDIUM);
//        route3.setLocality("Warszawa");
//        route4.setType("Trasa rowerowa");
//        route4.setDifficulty(RouteDifficulty.EXTREME);
//        route4.setLocality("Kraków");
//        route5.setType("Trasa dla biegaczy");
//        route5.setDifficulty(RouteDifficulty.EASY);
//        route5.setLocality("Gdańsk");
//        List<Route> allRoutes = List.of(route1,route2,route3,route4,route5);
//        //When
//        List<Route> result = allRoutes.stream()
//                .filter(route -> StringUtils.containsIgnoreCase( route.getType(), "trek"))
//                .collect(Collectors.toList() );
//        boolean result2 = true;
//        if(result.get(0).getLocality() != "Warszawa"){
//            result2 = false;
//        }
//        //Then
//        assertFalse(result2);
//    }
//
//}