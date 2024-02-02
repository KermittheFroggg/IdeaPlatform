package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;
import java.util.Map;

public class JsonParser {
    public static Map<String, Map<String, Object>> parser(String file) throws Exception {
        String extension = "";

        int i = file.lastIndexOf('.');
        if (i > 0) {
            extension = file.substring(i + 1);
        }
        if (extension.equals("json")) {
            ObjectMapper objectMapper = new ObjectMapper();

            Map<String, Map<String, Object>> tickets = objectMapper.readValue(Path.of(file).toFile(), Map.class);
            return tickets;
        }
        return null;
    }
}
