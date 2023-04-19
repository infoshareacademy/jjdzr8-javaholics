package com.javaholics.web.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS", schema = "meet2gether")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "user_event_jointable",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")
    private List<Route> routes;

    @Column(name = "user_name")
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


    public User(Long id, String name, String login) {
        this.id = id;
        this.name = name;
        this.login = login;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public SexChoice getSex() {
        return sex;
    }
    public void setSex(SexChoice sex) {
        this.sex = sex;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }    public void setImage(String image) {
        this.image = image;
    }

    public String getPrefferedRegionEvents() {
        return prefferedRegionEvents;
    }
    public void setPrefferedRegionEvents(String prefferedRegionEvents) {
        this.prefferedRegionEvents = prefferedRegionEvents;
    }
    public String getDectription() {
        return dectription;
    }
    public void setDectription(String dectription) {
        this.dectription = dectription;
    }
    public String getImage() {
        return image;
    }

}
