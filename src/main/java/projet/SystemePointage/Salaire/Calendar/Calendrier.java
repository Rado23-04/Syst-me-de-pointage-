package projet.SystemePointage.Salaire.Calendar;



import projet.SystemePointage.Salaire.Modele.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Calendrier {
    private static List<Date> Hollydays;
    private Employee employee;
    private static List<Date> daysWorkNormalEmployee;
    private static List<Date> daysWorkGuardian;

    public List<Date> normalEmployeeCalendar(List<Date> Hollydays) throws ParseException {
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE", Locale.ENGLISH);

        daysWorkNormalEmployee = new ArrayList<>();
        List<Date> June = new ArrayList<>();

        Calendar calendrierJune = Calendar.getInstance();
        calendrierJune.clear();
        calendrierJune.set(Calendar.YEAR, 2024);
        calendrierJune.set(Calendar.MONTH, Calendar.JUNE);
        calendrierJune.set(Calendar.DAY_OF_MONTH, 1);

        int daysInMonth = calendrierJune.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < daysInMonth; i++) {
            June.add(calendrierJune.getTime());
            calendrierJune.add(Calendar.DAY_OF_MONTH, 1);
        }
        for (Date day : June) {
            String dayName = dayFormat.format(day);
            if (!Hollydays.contains(day) && !dayName.equals("Sat") && !dayName.equals("Sun")) {
                daysWorkNormalEmployee.add(day);
            }
        }
        daysWorkNormalEmployee.removeAll(Hollydays);

        return daysWorkNormalEmployee;
    }
    public List<Date> employeeGuardian(List<Date> Hollydays)throws ParseException{
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE", Locale.ENGLISH);
        List<Date> june = new ArrayList<>();

        daysWorkGuardian = new ArrayList<>();
        Calendar calendarJune = Calendar.getInstance();
        calendarJune.clear();
        calendarJune.set(Calendar.YEAR,2024);
        calendarJune.set(Calendar.MONTH,Calendar.JUNE);
        calendarJune.set(Calendar.DAY_OF_MONTH,1);

        int daysinMonth = calendarJune.getActualMaximum(Calendar.DAY_OF_MONTH);

        for(int i= 0;i < daysinMonth;i++){
            june.add(calendarJune.getTime());
            calendarJune.add(Calendar.DAY_OF_MONTH,1);
        }
        for (Date date : june) {
            String dayName = dayFormat.format(date);
            if(!Hollydays.contains(date)){
                daysWorkGuardian.add(date);
            }
        }
        daysWorkGuardian.removeAll(Hollydays);
        return daysWorkGuardian;
    }


    public static void main(String[] args) throws ParseException {
        Calendrier calendrier = new Calendrier();
        List<Date> teste = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
        teste.add(format.parse("27-06-2024"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy", Locale.ENGLISH);
        List<Date> daysWorkNormalEmployee = calendrier.normalEmployeeCalendar(teste);
        for (Date jour : daysWorkNormalEmployee) {
            System.out.println(dateFormat.format(jour));
        }

    }
}

