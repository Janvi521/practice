package TryPractice;
import java.text.SimpleDateFormat;
import  java.util.*;
public class Practice {
    public static void main(String[] args) {
        Calendar gcal=new GregorianCalendar(2007,7,2);
        int  dayss=gcal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayss);
        SimpleDateFormat d=new SimpleDateFormat();
        Calendar cal= Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.getTime());
        System.out.println(d.format(cal.getTime()));
        System.out.println(Calendar.SUNDAY);



    }
}
