package projet.SystemePointage.Salaire.Service;

import org.springframework.stereotype.Service;
import projet.SystemePointage.Salaire.Calendar.Calendar;
import projet.SystemePointage.Salaire.Modele.CheckIn;
import projet.SystemePointage.Salaire.Modele.Employee;

import java.text.ParseException;
import java.util.*;
@Service
public class EmployeService {
    public int numberHoursWoked(Calendar c, Date dateStart, Date dateEnd, List<Date> hollydays, Employee employee) throws ParseException {
        CheckIn check1 = new CheckIn();

        HashMap<Date,Boolean> newCheck =  check1.check(c,dateStart,dateEnd,hollydays,employee);
        int increment = 0;
        for(Boolean value: newCheck.values()){
            if(value){
                increment++;
            }
        }
        int totalHours = employee.getCategory().getWorkDuration() * increment;
        return  totalHours;
    }
}
