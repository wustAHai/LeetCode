package easy;



import java.util.Date;

/**
 * @author chenz at 11:23 on 2022/1/3 .
 */
public class L1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        Date date = new Date();
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);
        int i = date.getDay();
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[i];
    }
}
