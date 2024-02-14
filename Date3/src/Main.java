import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        System.out.println("Data: " + data);

        String printYear = String.valueOf(data.getYear());
        System.out.println("Year: " + printYear);

        String printMonth = String.valueOf(data.getMonth());
        System.out.println("Month: " + printMonth);

        String printDay = String.valueOf(data.getDayOfMonth());
        System.out.println("Day: " + printDay);

        String printDayOfWeek = String.valueOf(data.getDayOfWeek());
        System.out.println("Day of week: " + printDayOfWeek);

    }
}
