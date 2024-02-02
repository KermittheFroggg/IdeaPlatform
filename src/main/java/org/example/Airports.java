package org.example;

public enum Airports {
    Владивосток("VVO"),
    ТельАвив("TLV"),
    Уфа("UFA"),
    Ларнака("LRN");

    private final String airport;

    Airports(String airport) {
        this.airport = airport;
    }

    public String getAirport() {
        return airport;
    }
}
