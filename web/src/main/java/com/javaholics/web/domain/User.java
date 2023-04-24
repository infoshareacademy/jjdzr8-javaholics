package com.javaholics.web.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        @ManyToMany
        @JoinTable(
                name = "user_event_jointable",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "event_id")
        )
        private List<Event> events;


    @OneToMany(mappedBy = "routeOwner")
    private List<Route> routes;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Enumerated(EnumType.STRING)
    private SexChoice sex;

    @Column(name = "image")
    private String image;

    @Column(name = "location")
    private String location;

    @Column(name = "preffered_region_event")
    private String prefferedRegionEvents;

    @Column(name = "description")
    private String dectription;

}
