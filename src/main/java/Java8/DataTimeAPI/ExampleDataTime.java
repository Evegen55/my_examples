package Java8.DataTimeAPI;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * Created by Evgenii_Lartcev on 8/10/2016.
 */
public class ExampleDataTime {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        LocalDate date = LocalDate.now();

        Instant instant = Instant.now();
        Thread.sleep(10000);
        Instant instant1 = Instant.now();

        int year = date.get(ChronoField.YEAR);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int day = date.get(ChronoField.DAY_OF_WEEK);

        DayOfWeek dayString = DayOfWeek.of(day);
        Month month1 = Month.of(month);
        Year year1 = Year.of(year);

        Duration d2 = Duration.between(instant, instant1);

        final Clock clock = Clock.systemUTC();
        final LocalDate dateFromClock = LocalDate.now( clock );
        final LocalDateTime datetimeFromClock = LocalDateTime.now( clock );

        //int day1 = instant.get(ChronoField.DAY_OF_WEEK);//Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: DayOfWeek
        //DayOfWeek dayString1 = DayOfWeek.of(day1);

        System.out.println(day + "\t" + month1 + "\t" + year1 + "\t" + dayString  + "\t");
        System.out.println(instant + "\t" + instant1);
        System.out.println(d2.getSeconds() + "\t" + d2.toNanos() + "\t" + d2.getNano());

        System.out.println( "clock.instant()" + "\t" + clock.instant() );
        System.out.println( clock.millis() );
        System.out.println( "clock.instant().getters" + "\t" + clock.instant().isSupported(ChronoField.DAY_OF_WEEK) );
        System.out.println( dateFromClock );
        System.out.println( datetimeFromClock);

    }
}
