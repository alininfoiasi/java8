package main.java.misc.dateapi;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateTesting {

    public void test1() {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println("Time in ms: " + millis);
        // use instead of
        System.out.println("Time in ms: " + System.currentTimeMillis());

        Instant instant = clock.instant();
        // legacy java.util.Date
        Date legacyDate = Date.from(instant);
        System.out.println("Date: " + legacyDate);
    }

    public void test2() {
        System.out.println(ZoneId.getAvailableZoneIds());

        // prints all available timezone ids
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        // ZoneRules[currentStandardOffset=+01:00]
        // ZoneRules[currentStandardOffset=-03:00]

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        // true
        System.out.println(now1.isAfter(now2));

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
        // -3
        System.out.println(hoursBetween);
        // -239
        System.out.println(minutesBetween);

        LocalTime late = LocalTime.of(23, 59, 59);
        // 23:59:59
        System.out.println(late);

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        // 13:37
        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        // FRIDAY
        System.out.println(dayOfWeek);

        germanFormatter =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);
        // 2014-12-24
        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter);
        System.out.println(xmas);

        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        // WEDNESDAY
        dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);
        // DECEMBER
        Month month = sylvester.getMonth();
        System.out.println(month);
        // 1439
        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        Instant instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();
        // Wed Dec 31 23:59:59 EET 2014
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        DateTimeFormatter formatter =
                DateTimeFormatter
                        .ofPattern("MMM dd, yyyy - HH:mm");

        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
        String string = formatter.format(parsed);
        // Nov 03, 2014 - 07:13
        System.out.println(string);
    }

    public static void main(String[] args) {
        DateTesting dateTesting = new DateTesting();
        dateTesting.test1();
        dateTesting.test2();
    }
}
