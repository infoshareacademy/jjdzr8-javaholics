/*
package com.javaholics.web.service;

import com.javaholics.web.domain.Event;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    Event event1 = new Event(1L,"Impreza");
    Event event2 = new Event(2L,"Wyzwanie");
    Event event3 = new Event(3L,"Dla leniowych");
    Event event4 = new Event(4L,"Urodziny Oli");
    Event event5 = new Event(5L,"Zakupy");
    @Test
    void getEventSearchDescription_schouldReturnSize4() {
        event1.setPlace("Katowice");
        event1.setDescription("Nie mam pomysłu na opis");
        event1.setRegion("Centrum");
        event2.setPlace("Oława");
        event2.setDescription("Niesamowity widok");
        event2.setRegion("Śląsk");
        event3.setPlace("Kraków");
        event3.setDescription("Nie narzekam");
        event3.setRegion("Dolnośląskie");
        event4.setPlace("Wrocław");
        event4.setDescription("Niestety zabrakło mi literek");
        event4.setRegion("Pomorskie");
        event5.setPlace("Gliwice");
        event5.setDescription("Super plan na wakacje");
        event5.setRegion("Mazury");
        List<Event> allRoutes = List.of(event1, event2, event3, event4, event5);
        //When
        List<Event> result = allRoutes.stream()
                .filter(event -> StringUtils.containsIgnoreCase(event.getDescription(), "Nie"))
                .collect(Collectors.toList());
        //Then
        assertThat(result).hasSize(4);
    }
    @Test
    void getEventSearchDescription_schouldReturn1() {
        event1.setPlace("Katowice");
        event1.setDescription("Nie mam pomysłu na opis");
        event1.setRegion("Centrum");
        event2.setPlace("Oława");
        event2.setDescription("Niesamowity widok");
        event2.setRegion("Śląsk");
        event3.setPlace("Kraków");
        event3.setDescription("Nie narzekam");
        event3.setRegion("Dolnośląskie");
        event4.setPlace("Wrocław");
        event4.setDescription("Niestety zabrakło mi literek");
        event4.setRegion("Pomorskie");
        event5.setPlace("Gliwice");
        event5.setDescription("Super plan na wakacje");
        event5.setRegion("Mazury");
        List<Event> allRoutes = List.of(event1, event2, event3, event4, event5);
        //When
        List<Event> result = allRoutes.stream()
                .filter(event -> StringUtils.containsIgnoreCase(event.getDescription(), "narzekam"))
                .collect(Collectors.toList());
        //Then
        assertEquals("Kraków", result.get(0).getPlace());
    }
    @Test
    void getEventSearchPlace_schouldReturn1() {
        event1.setPlace("Katowice");
        event1.setDescription("Nie mam pomysłu na opis");
        event1.setRegion("Centrum");
        event2.setPlace("Oława");
        event2.setDescription("Niesamowity widok");
        event2.setRegion("Śląsk");
        event3.setPlace("Kraków");
        event3.setDescription("Nie narzekam");
        event3.setRegion("Dolnośląskie");
        event4.setPlace("Wrocław");
        event4.setDescription("Niestety zabrakło mi literek");
        event4.setRegion("Pomorskie");
        event5.setPlace("Gliwice");
        event5.setDescription("Super plan na wakacje");
        event5.setRegion("Mazury");
        List<Event> allRoutes = List.of(event1, event2, event3, event4, event5);
        //When
        List<Event> result = allRoutes.stream()
                .filter(event -> StringUtils.containsIgnoreCase(event.getPlace(), "Gliwice"))
                .collect(Collectors.toList());
        //Then
        assertEquals("Mazury", result.get(0).getRegion());
    }
    @Test
    void getEventSearchName_schouldReturn1() {
        event1.setPlace("Katowice");
        event1.setDescription("Nie mam pomysłu na opis");
        event1.setRegion("Centrum");
        event2.setPlace("Oława");
        event2.setDescription("Niesamowity widok");
        event2.setRegion("Śląsk");
        event3.setPlace("Kraków");
        event3.setDescription("Nie narzekam");
        event3.setRegion("Dolnośląskie");
        event4.setPlace("Wrocław");
        event4.setDescription("Niestety zabrakło mi literek");
        event4.setRegion("Pomorskie");
        event5.setPlace("Gliwice");
        event5.setDescription("Super plan na wakacje");
        event5.setRegion("Mazury");
        List<Event> allRoutes = List.of(event1, event2, event3, event4, event5);
        //When
        List<Event> result = allRoutes.stream()
                .filter(event -> StringUtils.containsIgnoreCase(event.getEventName(), "Uro"))
                .collect(Collectors.toList());
        //Then
        assertEquals(4,result.get(0).getId() );
    }

}*/
