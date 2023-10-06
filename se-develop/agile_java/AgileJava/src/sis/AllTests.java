package sis;

import junit.framework.TestSuite;
import sis.studentInfo.*;
import sis.report.*;

public class AllTests {

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(sis.report.AllTests.suite());
		suite.addTest(sis.studentInfo.AllTests.suite());
		suite.addTest(sis.summer.AllTests.suite());
		return suite;
	}
}