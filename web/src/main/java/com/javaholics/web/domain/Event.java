package com.javaholics.web.domain;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "EVENTS", schema = "meet2gether")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //    @ManyToOne
    //    @JoinColumn(name = "route_id")
    //    private Route route;
    //
    //    @ManyToMany(mappedBy = "events")
    //    private List<User> users;

    @NotBlank
    @Column(name = "event_name")
    private String eventName;

    @NotBlank
    @Column(name = "place")
    private String place;

    @NotBlank
    @Column(name = "region")
    private String region;

    //private long ownerOfEvent;

    @Column(name = "description")
    private String description;

    @Min(value = 1)
    @Column(name = "users_count")
    private Integer usersCount;

    //    @FutureOrPresent()
    //    @NotNull
    //    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    //    @Column(name = "date")
    //    private LocalDateTime date;

    @Column(name = "time")
    private String time;

}
