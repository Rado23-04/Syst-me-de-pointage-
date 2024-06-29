package projet.SystemePointage.Salaire.EmployeeService;

import org.junit.jupiter.api.Test;
import projet.SystemePointage.Salaire.Calendar.Calendar;
import projet.SystemePointage.Salaire.Modele.Category;
import projet.SystemePointage.Salaire.Modele.Employee;
import projet.SystemePointage.Salaire.Modele.Enum.CategorieEnum;
import projet.SystemePointage.Salaire.Modele.Salary;
import projet.SystemePointage.Salaire.Service.EmployeService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoursWorkedTest {
    @Test
    void hoursWorked() throws ParseException {
        Calendar c = new Calendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date startDate = dateFormat.parse("01-06-2024");
        Date endDate = dateFormat.parse("30-06-2024");

        Salary salary = new Salary(15000.00, 12500.00);
        Category category = new Category(CategorieEnum.GUARDIAN, 8, salary, 15200);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthday = LocalDate.parse("12-12-2012", formatter);

        List<Date> daysWork = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        daysWork.add(format.parse("17-06-2024"));
        daysWork.add(format.parse("25-06-2024"));
        daysWork.add(format.parse("26-06-2024"));

        Employee employee = new Employee("Rabe", 555, birthday, birthday, birthday, salary, category);
        EmployeService employeService = new EmployeService();
        int result = employeService.numberHoursWoked(c,startDate,endDate,daysWork,employee);
        assertEquals(result,208);
    }
}
