package sis.summer;
import java.util.*;
import sis.studentInfo.*;

public class SummerCourseSession extends Session {
	@Override
	protected int getSessionLength() {
		return 8;
	}
	public static SummerCourseSession create(
			String department,
			String number,
			Date startDate) {
		return new SummerCourseSession(department, number, startDate);
	}
	private SummerCourseSession(
		String department,
		String number,
		Date startDate
		) {
		super(department, number, startDate);
	}
	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		int daysInWeek = 7;
		int daysFromFridayToMonday = 3;
		int numberOfDays =getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
}