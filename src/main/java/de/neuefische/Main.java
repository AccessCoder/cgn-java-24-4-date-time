package de.neuefische;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        //LocalDate = Nur Datum
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        //LocalDateTime = Datum & Uhrzeit
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        //ZonedDateTime = Datum & Uhrzeit & Zeitzone
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        //Instant = Zulu Zeitpunkt
        Instant instant = Instant.now();
        System.out.println(instant);

        //Instant zu LocalDateTime
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime convertedLocalDateTime = instant.atZone(zoneId).toLocalDateTime();
        System.out.println("Converted Instant to LDT: " + convertedLocalDateTime);

        //LocalDateTime zu Instant
        Instant convertedInstant = localDateTime.atZone(zoneId).toInstant();
        System.out.println("Converted LDT to Instant " + convertedInstant);

        //Format der Zeitangabe anpassen
        //E = Wochentag / d = Tag / M = Monat / y = Jahr / H = Stunde / m = Minute / s = Sekunde / n = nano
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy : HH:mm:ss");

        System.out.println(localDateTime.format(formatter));

        //String in LocalDateTime umwandeln
        LocalDateTime parsedLocalDate = LocalDateTime.parse("12.08.2024 : 22:25:38", formatter);
        System.out.println("Parse String to LDT: " + parsedLocalDate);

        //Differenz zwischen zwei Zeitpunkten errechnen
        long hoursBetween = ChronoUnit.HOURS.between(parsedLocalDate, LocalDateTime.now());
        System.out.println(hoursBetween);
        long secondsBetween = ChronoUnit.SECONDS.between(parsedLocalDate, LocalDateTime.now());
        System.out.println(secondsBetween);


    }
}