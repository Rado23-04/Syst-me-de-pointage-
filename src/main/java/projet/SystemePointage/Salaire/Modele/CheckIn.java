package projet.SystemePointage.Salaire.Modele;
import projet.SystemePointage.Salaire.Calendar.Calendar;
import java.text.ParseException;
import java.util.*;


public class CheckIn {
    public HashMap<Date, Boolean> check(Calendar c, Date dateStart, Date dateEnd, List<Date> hollydays, Employee employee) throws ParseException {
        HashMap<Date, Boolean> checkin = new HashMap<>();
        List<Date> dates = c.daysWork(dateStart, dateEnd, hollydays, employee);

        for (Date jour : dates) {
            checkin.put(jour, true);
        }
        return checkin;
    }
    public void updateCheckinAbsence(HashMap<Date, Boolean> checkin, Date dateToUpdate) {
        if (checkin.containsKey(dateToUpdate)) {
            checkin.put(dateToUpdate, false);
        }
    }

}