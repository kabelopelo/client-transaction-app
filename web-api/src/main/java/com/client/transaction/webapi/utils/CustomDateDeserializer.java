package com.client.transaction.webapi.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Component
public class CustomDateDeserializer extends StdDeserializer<Date> {

    private static final long serialVersionUID = -5427139157878044041L;
    private DateTimeFormatter formatter;

    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jsonparser, DeserializationContext context) throws IOException {
        formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd'T'HH:mm:ss.SSS'Z'][yyyy-MM-dd'T'HH:mm:ss][yyyy-MM-dd HH:mm:ss][yyyy-MM-dd]");
        String date = jsonparser.getText();
        try {
            LocalDate dt = LocalDate.parse(date, formatter);
            return java.sql.Date.valueOf(dt);
        } catch (DateTimeParseException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }
}