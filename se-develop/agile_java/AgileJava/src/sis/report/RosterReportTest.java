package sis.report;

import java.util.*;
import junit.framework.TestCase;
import sis.studentInfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class RosterReportTest extends TestCase{
	private CourseSession courseSession;
	private Date startDate;

	public void setUp() {
		courseSession = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));
	}

	public void testRosterReport() {
		courseSession.enroll(new Student("A"));
		courseSession.enroll(new Student("B"));

		String rosterReport = new RosterReport(courseSession).getRosterReport();
		System.out.println(rosterReport);
		assertEquals(RosterReport.ROSTER_REPORT_HEADER + 
			"A" + RosterReport.NEWLINE +
			"B" + RosterReport.NEWLINE +
			RosterReport.ROSTER_REPORT_FOOTER + "2" + RosterReport.NEWLINE , rosterReport);
	}


}