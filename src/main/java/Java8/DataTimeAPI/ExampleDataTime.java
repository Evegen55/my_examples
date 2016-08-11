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

        // Get the zoned date/time
        final ZonedDateTime zonedDatetime = ZonedDateTime.now();
        final ZonedDateTime zonedDatetimeFromClock = ZonedDateTime.now( clock );
        final ZonedDateTime zonedDatetimeFromZone = ZonedDateTime.now( ZoneId.of( "America/Los_Angeles"));

        // Get duration between two dates
        final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
        final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
        final Duration duration = Duration.between( from, to );


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

        System.out.println( zonedDatetime );
        System.out.println( zonedDatetimeFromClock );
        System.out.println( zonedDatetimeFromZone );


        System.out.println( "Duration in days: " + duration.toDays() );
        System.out.println( "Duration in hours: " + duration.toHours() );
    }
}
