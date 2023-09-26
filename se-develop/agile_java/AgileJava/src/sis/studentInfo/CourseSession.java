package sis.studentInfo;


import java.util.*;
public class CourseSession  implements Comparable<CourseSession> {
	
	private static int count;
	
	private String department; 
	private String number;
	private Date startDate;
	private int numberOfCredits;

	private List<Student> allStudents = new ArrayList<Student>();

	protected CourseSession (String department , String number , Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
//		CourseSession.incrementCount();
	}
	public static CourseSession create(String department,String number,Date startDate) {
		incrementCount();
		return new CourseSession(department, number, startDate);
	}

	public String getDepartment() {
		return this.department;
	}

	public String getNumber() {
		return this.number;
	}

	public int getNumberOfStudents() {
		return this.allStudents.size();
	}

	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		this.allStudents.add(student);
	}

	public Student get(int index) {
		return this.allStudents.get(index);
	}
	protected int getSessionLength() {
		return 16;
	}

	protected Date getStartDate() {
		return this.startDate;
	}

	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(this.startDate);
		int daysInWeek = 7;
		int sessionLength = 16;
		calendar.add(Calendar.DAY_OF_YEAR , daysInWeek * sessionLength);
		return calendar.getTime();
	}

	public List<Student> getAllStudents() {
		return this.allStudents;
	}
	private static void incrementCount() {
		count = count + 1;
	}
	static int getCount() {
		return count;
	}
	static void resetCount() {
		count = 0;
	}
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	public int compareTo(CourseSession that ) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0)
			compare = this.getNumber().compareTo(that.getNumber());
		return compare;
	}
}