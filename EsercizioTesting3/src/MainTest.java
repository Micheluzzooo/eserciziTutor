import org.junit.Test;

import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;

public class MainTest {
    Main main = new Main();

    @Test
    public void testFormatDate() {
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        String result = main.formatDate(data);
        assertEquals("01-marzo-2023", result);
    }
}