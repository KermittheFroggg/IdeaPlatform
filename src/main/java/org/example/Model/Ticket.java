package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    String origin;
    String origin_name;
    String destination;
    String destination_name;
    String carrier;
    int stops;
    int price;
    LocalDateTime departure;
    LocalDateTime arrival;
}


