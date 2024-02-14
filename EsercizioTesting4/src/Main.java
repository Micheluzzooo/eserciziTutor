import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        System.out.println("Data: " + data);

        System.out.println("Year: " + printYear(data));
        System.out.println(("Month: " + printMonth(data)));
        System.out.println(("Day: " + printDay(data)));
        System.out.println(("Day of week: " + printDayOfWeek(data)));

    }
    public static String printYear(OffsetDateTime data) {
        String getYearFromData = String.valueOf(data.getYear());
        return getYearFromData;
    }

    public static String printMonth(OffsetDateTime data) {
        String getMonthFromData = String.valueOf(data.getMonth());
        return getMonthFromData;
    }

    public static String printDay(OffsetDateTime data) {
        String getDayFromData = String.valueOf(data.getDayOfMonth());
        return getDayFromData;
    }

    public static String printDayOfWeek(OffsetDateTime data) {
        String getDayFromWeek = String.valueOf(data.getDayOfWeek());
        return getDayFromWeek;
    }
}