package pat.hacks.lifemanager;

import java.util.Calendar;

public class ScheduleData {

    int currentMonth;
    int currentYear;
    int currentDay;

    String[] monthNames = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};

    Integer[] monthCounter = {31,28,31,30,31,30,31,31,30,31,30,31};

    String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};

    public ScheduleData() {
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
        currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        currentDay = Calendar.getInstance().get(Calendar.DATE);
    }

    public void previousMonth()
    {
        currentMonth -= 1;
        currentDay = 1;

        if (currentMonth <= 0)
        {
            currentMonth = 12;
            currentYear -= 1;
        }
    }
    public void nextMonth()
    {
        currentMonth += 1;

        if (currentMonth > 12)
        {
            currentMonth = 1;
            currentYear += 1;
        }

        currentDay = monthCounter[currentMonth];
    }
}

