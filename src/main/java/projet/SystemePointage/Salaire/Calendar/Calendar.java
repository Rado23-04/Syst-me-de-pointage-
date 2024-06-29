package projet.SystemePointage.Salaire.Calendar;

import projet.SystemePointage.Salaire.Modele.Employee;
import projet.SystemePointage.Salaire.Modele.Enum.CategorieEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Calendar {
    public List<Date> daysWork(Date startDate, Date endDate, List<Date> hollyDays, Employee employee) throws ParseException {
        List<Date> daysWork = new ArrayList<>();
        java.util.Calendar calendrier = java.util.Calendar.getInstance();
        calendrier.setTime(startDate);

        while (calendrier.getTime().before(endDate)) {
            Date day = calendrier.getTime();
            if (!hollyDays.contains(day)) {
                if (employee.getCategory().getNameCategory()!= CategorieEnum.GUARDIAN) {
                    String dayName = new SimpleDateFormat("EEE", Locale.ENGLISH).format(day);
                    if (!dayName.equals("Sat") &&!dayName.equals("Sun")) {
                        daysWork.add(day);
                    }
                } else {
                    daysWork.add(day);
                }
            }
            calendrier.add(java.util.Calendar.DAY_OF_MONTH, 1);
        }

        return daysWork;
    }

}
