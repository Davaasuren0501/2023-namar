package sis.studentInfo;

import java.util.*;
import junit.framework.TestCase;
import static sis.studentInfo.DateUtil.*;
public class CourseSessionTest extends TestCase {

	private CourseSession courseSession;
	private Date startDate;
	private static final int CREDITS = 3;

	public void setUp() {
		startDate = createDate(2003 , 1 , 6);
		courseSession = createCourseSession();
	}

	public void testCreate() {
		assertEquals("ENG",courseSession.getDepartment());
		assertEquals("001",courseSession.getNumber());
		assertEquals(0,courseSession.getNumberOfStudents());
		assertEquals(startDate,courseSession.getStartDate());
	}
	public void testCourseDates() {
		Date sixteenWeeksOut = createDate(2003, 4, 28);
		assertEquals(sixteenWeeksOut, courseSession.getEndDate());
	}

	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVeo");
		courseSession.enroll(student1);

		assertEquals(1 , courseSession.getNumberOfStudents());
		assertEquals(student1 , courseSession.get(0));

		Student student2 = new Student("Coralee DeVaughn");
		courseSession.enroll(student2);

		assertEquals(2 , courseSession.getNumberOfStudents());
		assertEquals(student2 , courseSession.get(1));

		assertEquals(student1 , courseSession.get(0));
	}
	public void testCount() {
		CourseSession.resetCount();
		createCourseSession();
		assertEquals(1, CourseSession.getCount());
		createCourseSession();
		assertEquals(2, CourseSession.getCount());
	}
	private CourseSession createCourseSession() {
		CourseSession session = CourseSession.create("ENG", "001", startDate);
		session.setNumberOfCredits(CourseSessionTest.CREDITS);
		return session;
	}
}
