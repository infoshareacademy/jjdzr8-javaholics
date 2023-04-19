package com.javaholics.web.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "ROUTES", schema = "meet2gether")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    private List<Event> events;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Column(name = "route_name")
    private String name;

    @Column(name = "route_owner")
    private User routeOwner;

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
    private RouteDifficulty difficulty;

    @Column(name = "file")
    private String routeFile;

    private long userId;

    @Column(name = "avg_rating")
    private double avgRating;

    @NotBlank
    @Column(name = "type")
    private String type;

    @Min(value = 1)
    @Max(value = 1000)
    @Column(name = "length")
    private double length;

    @FutureOrPresent()
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "time")
    private String time;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Route(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPlaceStart() {
        return placeStart;
    }

    public void setPlaceStart(String placeStart) {
        this.placeStart = placeStart;
    }

    public String getPlaceStop() {
        return placeStop;
    }

    public void setPlaceStop(String placeStop) {
        this.placeStop = placeStop;
    }


    public String getRouteFile() {
        return routeFile;
    }

    public void setRouteFile(String  routeFile) {
        this.routeFile = routeFile;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public RouteDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(RouteDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locality='" + locality + '\'' +
                ", placeStart='" + placeStart + '\'' +
                ", placeStop='" + placeStop + '\'' +
                ", difficulty=" + difficulty +
                ", userId=" + userId +
                ", avgRating=" + avgRating +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", date=" + date +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) && Objects.equals(name, route.name) && Objects.equals(locality, route.locality) && Objects.equals(placeStart, route.placeStart) && Objects.equals(placeStop, route.placeStop) && Objects.equals(difficulty, route.difficulty) && Objects.equals(type, route.type) && Objects.equals(avgRating, route.avgRating) && Objects.equals(userId, route.userId)&& Objects.equals(length, route.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, locality, placeStart, placeStop, difficulty, userId, avgRating, type, length, date);
    }
}

