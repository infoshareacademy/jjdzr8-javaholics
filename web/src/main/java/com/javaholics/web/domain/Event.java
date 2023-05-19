package com.javaholics.web.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "route_id")
        private Route route;

        @ManyToMany(mappedBy = "events")
        private List<User> users;

    @NotBlank
    @Column(name = "event_name")
    private String eventName;

//    @NotBlank
//    @Column(name = "place")
//    private String place;

    @NotBlank
    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User ownerOfEvent;

    @Column(name = "description")
    private String description;

    @Min(value = 1)
    @Column(name = "users_count")
    private Integer usersCount;

    @FutureOrPresent()
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "event_date_time")
    private LocalDateTime eventDateTime;

    @Column(name="create_date")
    private LocalDateTime createDate;

}

