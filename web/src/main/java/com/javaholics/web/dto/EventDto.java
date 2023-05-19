package com.javaholics.web.dto;

import com.javaholics.web.domain.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDto {

    private Long id;

    @NotBlank
    private String eventName;

    @NotBlank
    private long route;

    @NotBlank
    private Region region;

    private long ownerOfEvent;

    private String description;

    @Min(value = 1)
    private Integer usersCount;

    @FutureOrPresent()
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventDateTime;

    private LocalDateTime createDate;

}
