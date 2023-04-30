package com.javaholics.web.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ROUTES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route", cascade = CascadeType.ALL)
    private List<Event> events;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User routeOwner;

    @NotBlank
    @Column(name = "route_name")
    private String name;

    @NotBlank
    @Column(name = "locality")
    private String locality;

    @NotBlank
    @Column(name = "place_start")
    private String placeStart;

    @NotBlank
    @Column(name = "place_stop")
    private String placeStop;

    @Column(name = "difficulty")
    @Enumerated(EnumType.STRING)
    private RouteDifficulty difficulty;

    @Column(name = "file")
    private String routeFile;

    @Column(name = "avg_rating")
    private double avgRating;

    @NotBlank
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RouteType routeType;

    @Min(value = 1)
    @Max(value = 1000)
    @Column(name = "length")
    private double length;

    @FutureOrPresent()
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")

    @Column(name="create_date")
    private LocalDateTime createDate;

}

