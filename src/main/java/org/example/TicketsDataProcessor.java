package org.example;

import org.example.Model.Ticket;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;


public class TicketsDataProcessor {

    private List<Ticket> tickets;

    public TicketsDataProcessor(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Map<String, String> findMinTime(Airports destination, Airports origin) {

        var carriersMinTimeTikets = tickets.stream()
                .filter(ticket -> (checkDestination(destination, origin, ticket)))
                .collect(Collectors.groupingBy(Ticket::getCarrier,
                        Collectors.minBy(Comparator.comparing(ticket ->
                                Duration.between(ticket.getDeparture(), ticket.getArrival()).toMinutes()))));
        Map<String, String> carriersMinTime = carriersMinTimeTikets.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> DateTimeOperator.normilizeDuration(
                                Duration.between(entry.getValue().get().getDeparture(),
                                entry.getValue().get().getArrival()))));
        return carriersMinTime;
    }

    public static boolean checkDestination(Airports destinationAirport,
                                           Airports originAirport,
                                           Ticket ticket) {
        String destination = destinationAirport.getAirport();
        String origin = originAirport.getAirport();
        return (destination.equals(ticket.getDestination()) && origin.equals(ticket.getOrigin()))
                || (origin.equals(ticket.getDestination()) && destination.equals(ticket.getOrigin()));
    }

    public int findAveragePrice(Airports destination,
                                Airports origin) {
        double averagePrice = tickets.stream()
                .filter(ticket -> (checkDestination(destination, origin, ticket)))
                .collect(Collectors.averagingInt(Ticket::getPrice));
        return (int) Math.round(averagePrice);
    }


    public int findMedianPrice(Airports destination,
                               Airports origin) {
        List<Ticket> filteredTickets = tickets.stream()
                .filter(ticket -> checkDestination(destination, origin, ticket))
                .sorted(Comparator.comparing(Ticket::getPrice))
                .toList();

        int medianPrice;
        int ticketsSize = filteredTickets.size();
        if (ticketsSize % 2 == 0) {
            int price1 = filteredTickets.get(ticketsSize / 2 - 1).getPrice();
            int price2 = filteredTickets.get(ticketsSize / 2).getPrice();
            medianPrice = (price1 + price2) / 2;
        } else {
            medianPrice = filteredTickets.get(ticketsSize / 2).getPrice();
        }
        return medianPrice;
    }
}
