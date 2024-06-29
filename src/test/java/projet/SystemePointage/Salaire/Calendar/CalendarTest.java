package projet.SystemePointage.Salaire.Calendar;

import org.junit.jupiter.api.Test;
import projet.SystemePointage.Salaire.Modele.Category;
import projet.SystemePointage.Salaire.Modele.Employee;
import projet.SystemePointage.Salaire.Modele.Enum.CategorieEnum;
import projet.SystemePointage.Salaire.Modele.Salary;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalendarTest {
    @Test
    void DaysWork() throws ParseException {
        Calendar calendar = new Calendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        List<Date> daysWork = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        daysWork.add(format.parse("17-06-2024"));
        daysWork.add(format.parse("25-06-2024"));
        daysWork.add(format.parse("26-06-2024"));

        Date startDate = dateFormat.parse("01-06-2024");
        Date endDate = dateFormat.parse("30-06-2024");

        Salary salary = new Salary(15000.00,12500.00);
        Category category = new Category(CategorieEnum.DRIVER,8,salary,15200);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse("12-12-2012",formatter);

        Employee employee = new Employee("Rabe",555, birthday,birthday,birthday,salary,category);

        List<Date> newList = calendar.daysWork(startDate,endDate,daysWork,employee);

        for (Date workDay : daysWork) {
            assertTrue(!newList.contains(workDay));
        }

    }
}

