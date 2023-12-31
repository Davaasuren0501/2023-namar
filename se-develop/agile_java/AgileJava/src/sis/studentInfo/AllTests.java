package sis.studentInfo;

import junit.framework.TestSuite;
public class AllTests {

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(StudentTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(DateUtilTest.class);
		suite.addTestSuite(BasicGradingStrategyTest.class);
		suite.addTestSuite(HonorsGradingStrategyTest.class);
		suite.addTestSuite(CourseSessionTest.class);
		suite.addTestSuite(PerformanceTest.class);
		suite.addTestSuite(SessionTest.class);
		suite.addTestSuite(ScorerTest.class);
		return suite;
	}
}