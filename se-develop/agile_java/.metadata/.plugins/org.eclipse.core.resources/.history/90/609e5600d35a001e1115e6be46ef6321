package sis.report;

import java.util.*;
import sis.studentinfo.*;

public class RosterReport {

	public static final String NEWLINE = System.getProperty("line.separator");
	public static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-------" + NEWLINE;
	public static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

	private CourseSession courseSession;
	private List<Student> allStudents;
	public RosterReport(CourseSession courseSession) {
		this.courseSession = courseSession;
		this.allStudents = courseSession.getAllStudents();
	}

	public String getRosterReport() {
		StringBuffer buffer = new StringBuffer();
		this.writeHeader(buffer);
		this.writeBody(buffer);
		this.writeFooter(buffer);
		return buffer.toString();
	}

	private void writeHeader(StringBuffer buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}

	private void writeBody(StringBuffer buffer) {
		for(Student student : allStudents) {
			buffer.append(student.getName());
			buffer.	append(NEWLINE);
		}
	}

	private void writeFooter(StringBuffer buffer) {
		buffer.append(ROSTER_REPORT_FOOTER + allStudents.size() + NEWLINE);
	}
}