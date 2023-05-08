package com.javaholics.web.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    //@Column(nullable = false)
    private String login;

    @Enumerated(EnumType.STRING)
    private SexChoice sex;

    @Email
    //@Column(nullable = false)
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "preffered_region_event")
    private String prefferedRegionEvents;

    @Column(name = "description")
    private String desctription;

    @Enumerated(EnumType.STRING)
    //@NotNull
    private UserProvider loginProvider;

    //@JsonIgnore
    private String password;

}
