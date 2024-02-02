package org.example;

import org.example.Model.Ticket;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.DateTimeOperator.parseDateTime;

public class JsonDataFormatter {

    private List<Map<String, Object>> ticketsData;

    public JsonDataFormatter(Map<String, Map<String, Object>> ticketsJson) {
        this.ticketsData = (List<Map<String, Object>>) ticketsJson.get("tickets");
    }

    public Ticket jsonToTicket(Map<String, Object> ticket) {
        LocalDateTime departureDateTime = parseDateTime(
                (String) ticket.get("departure_date"),
                (String) ticket.get("departure_time")
        );
        LocalDateTime arrivalDateTime = parseDateTime(
                (String) ticket.get("arrival_date"),
                (String) ticket.get("arrival_time")
        );

        return new Ticket((String) ticket.get("origin"),
                (String) ticket.get("origin_name"),
                (String) ticket.get("destination"),
                (String) ticket.get("destination_name"),
                (String) ticket.get("carrier"),
                (Integer) ticket.get("stops"),
                (Integer) ticket.get("price"),
                departureDateTime,
                arrivalDateTime
        );
    }

    public List<Ticket> getTickets() {
        return ticketsData.stream()
                .map(this::jsonToTicket)
                .collect(Collectors.toList());
    }
}
