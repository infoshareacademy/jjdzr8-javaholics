package com.javaholics.web.dto;

import com.javaholics.web.domain.RouteDifficulty;
import com.javaholics.web.domain.RouteType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteDto {

    private long id;

    private String name;

    private Integer routeOwner;

    private String locality;

    @NotBlank
    private String placeStart;

    @NotBlank
    private String placeStop;

    private RouteDifficulty difficulty;

    private String routeFile;

    private double avgRating;

    @NotBlank
    private RouteType type;

    @Min(value = 1)
    @Max(value = 1000)
    private double length;

    @FutureOrPresent()
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDate createDate;


}
