package certification;

import java.util.Calendar;
import java.util.Locale;

public class Dates {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(new Locale("en","AR"));
		l(cal.getFirstDayOfWeek() == Calendar.SUNDAY);
		l(cal.getFirstDayOfWeek());
		l(cal.getTime());
		cal.add(Calendar.MONTH, 22);
		l(cal.getTime());
	}
	
	public static void l(Object a){
		System.out.println(a);
	}

}
