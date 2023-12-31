package sis.studentInfo;
import junit.framework.TestCase;

import java.net.MalformedURLException;
import java.util.*;
import static sis.studentInfo.DateUtil.createDate;

abstract public class SessionTest extends TestCase {
	private Session session;
	private Date startDate;
	public static final int CREDITS = 3;
	public void setUp() {
		startDate = createDate(2003, 1, 6);
		session = createSession("ENGL", "101", startDate);
		session.setNumberOfCredits(CREDITS);
	}
	abstract protected Session createSession( String department, String number, Date startDate );
	
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());
	}
	
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		
		assertEquals(CREDITS, student2.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	public void testComparable() {
		final Date date = new Date();
		Session sessionA = createSession("CMSC", "101", date);
		Session sessionB = createSession("ENGL", "101", date);
		
		assertTrue(sessionA.compareTo(sessionB) < 0);
		assertTrue(sessionB.compareTo(sessionA) > 0);
		
		Session sessionC = createSession("CMSC", "101", date);
		assertEquals(0, sessionA.compareTo(sessionC));
		
		Session sessionD = createSession("CMSC", "210", date);
		assertTrue(sessionC.compareTo(sessionD) < 0);
		assertTrue(sessionD.compareTo(sessionC) > 0);
	}
	public void testSessionUrl() throws MalformedURLException {
		final String url = "http://course.langrsoft.com/cmsc300";
		session.setUrl(url);
		assertEquals(url, session.getUrl().toString());
	}
	public void testInvalidSessionUrl() {
		final String url = "httsp://course.langrsoft.com/cmsc300";
		try {
			session.setUrl(url);
			fail("expected exception due to invalid protocol in URL");
		}
		catch (MalformedURLException success) {
		}
	}
}
