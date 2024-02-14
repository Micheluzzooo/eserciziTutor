import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        System.out.println(formatDate(data));

    }

    public static String formatDate(OffsetDateTime data) {
        DateTimeFormatter formatterMedium = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String formattedMedium = data.format(formatterMedium);
        return formattedMedium;

    }
}