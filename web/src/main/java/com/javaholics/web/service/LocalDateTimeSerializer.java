package com.javaholics.web.service;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(final LocalDateTime localDateTime, final Type type, final JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(formatter.format(localDateTime));
    }
}
