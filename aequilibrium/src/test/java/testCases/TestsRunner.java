package testCases;

import org.testng.TestNG;

import resources.base;

public class TestsRunner extends base {

	static TestNG testNGRunner;

	public static void main(String[] args) {

		testNGRunner = new TestNG();

		testNGRunner.setTestClasses(new Class[] { LoginTestSuite.class });
		
		testNGRunner.run();

	}

}
