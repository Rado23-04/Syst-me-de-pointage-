package projet.SystemePointage.Salaire.Calendar;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class CalendarTest {
    @Test
    void employeeDaysWork() throws ParseException {
        Calendrier calendrier = new Calendrier();
        List<Date> daysWork = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        daysWork.add(format.parse("17-06-2024"));
        daysWork.add(format.parse("25-06-2024"));
        daysWork.add(format.parse("26-06-2024"));

        List<Date> daysWorkNormalEmployee = calendrier.normalEmployeeCalendar(daysWork);

        List<Date> expectedAbsentDates = new ArrayList<>();
        expectedAbsentDates.add(format.parse("18-06-2024"));
        expectedAbsentDates.add(format.parse("24-06-2024"));
        expectedAbsentDates.add(format.parse("27-06-2024"));

        for (Date date : expectedAbsentDates) {
            assertFalse(!daysWorkNormalEmployee.contains(date));
        }
    }

    @Test
    void guardian () throws ParseException{
        Calendrier calendrier = new Calendrier();
        List<Date> guardian = new ArrayList<>();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        guardian.add(format.parse("17-06-2024"));
        guardian.add(format.parse("25-06-2024"));
        guardian.add(format.parse("26-06-2024"));

        List<Date> daysWorkGuardianEmployee = calendrier.normalEmployeeCalendar(guardian);

        List<Date> expectedAbsentDates = new ArrayList<>();
        expectedAbsentDates.add(format.parse("18-06-2024"));
        expectedAbsentDates.add(format.parse("24-06-2024"));
        expectedAbsentDates.add(format.parse("27-06-2024"));

        for (Date date : expectedAbsentDates) {
            assertFalse(!daysWorkGuardianEmployee.contains(date));
        }
    }
}
