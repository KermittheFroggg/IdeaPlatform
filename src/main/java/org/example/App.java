package org.example;

import org.example.Model.Ticket;

import java.util.*;

import static org.example.Airports.*;

class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Укажите адрес файла:");
        String fileAddress = scanner.nextLine();

        Map<String, Map<String, Object>> ticketsData = JsonParser.parser(fileAddress);
        if (ticketsData == null) {
            System.out.println("Wrong file format");
            return;
        }
        List<Ticket> tickets = new JsonDataFormatter(ticketsData).getTickets();
        TicketsDataProcessor ticketsProcessor = new TicketsDataProcessor(tickets);
        Map<String, String> minTime = ticketsProcessor.findMinTime(Владивосток, ТельАвив);
        System.out.println("Минимальное время полета между городами Владивосток " +
                "и Тель-Авив для каждого авиаперевозчика : " + minTime);
        System.out.println("Разница между средней и медианой ценой для" +
                " полета  городами  Владивосток и Тель-Авив : "
                + (ticketsProcessor.findAveragePrice(Владивосток, ТельАвив) -
                ticketsProcessor.findMedianPrice(ТельАвив, Владивосток)));
    }
}

