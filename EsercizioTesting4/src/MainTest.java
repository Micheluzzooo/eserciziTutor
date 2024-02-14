import org.junit.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;

public class MainTest {
    Main main = new Main();

    @Test
    public void testPrintYear() {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        String result = main.printYear(data);
        assertEquals("2023", result);

    }

    @Test
    public void testPrintMonth() {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        String result = main.printMonth(data);
        assertEquals("March", result);

    }

    @Test
    public void testPrintDay() {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        String result = main.printDay(data);
        assertEquals("01", result);

    }

    @Test
    public void testPrintDayOfWeek() {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        String result = main.printDayOfWeek(data);
        assertEquals("WEDNESDAY", result);

    }
}