package com.syllab.fetes;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        var horloge = Clock.systemUTC();
        // Dates
        var aujourdhui = LocalDate.now();
        var apresDemain = aujourdhui.plusDays(2);
        var noel = LocalDate.of(2023, Month.DECEMBER, 25);
                
        System.out.println(aujourdhui);
        System.out.println(apresDemain);

        /* Formatage
        System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(noel.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(noel.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        */

        /* Lecture
        var printemps = LocalDate.parse(
            "20/03/2024", 
            DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.FRANCE)
        );

        System.out.println(printemps.format(
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.FRANCE)
        ));
        */
        
        /* Heures
        var maintenant = LocalTime.now(horloge);

        System.out.println(maintenant.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)));
        System.out.println(maintenant.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)));
        System.out.println(maintenant.format(DateTimeFormatter.ISO_TIME));
        */

        /* Dates + heures / fuseaux
        var nouvelAn          = LocalDateTime.of(2024, 1, 1, 0, 0, 0, 0);
        var nouvelAnParis     = ZonedDateTime.of(nouvelAn, ZoneId.of("Europe/Paris"));
        var nouvelAnGreenwich = OffsetDateTime.of(nouvelAn, ZoneOffset.ofHours(0));
        */
    }
}
