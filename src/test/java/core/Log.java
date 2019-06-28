package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;

public class Log {
	public static Logger logger = LogManager.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName){
	 
		logger.info("*************************************************************************");
	 
		logger.info("Starting test case: "+sTestCaseName);
	 
		logger.info("*************************************************************************"); 
	}
	 
		//This is to print log for the ending of the test case
	 
	 public static void endTestCase(){
	 
		 logger.info("***********************        -E---N---D-       ***********************");
	 
		 logger.info("X");
	 
		 logger.info("X");
	 
	}
	 
	public static void logTestcaseResult(ITestResult result) {
		int resultStatus = result.getStatus();
		if ((resultStatus == ITestResult.SUCCESS)) {
			logger.info("***********************   TEST CASE IS PASSED!   ***********************");
		}else if (resultStatus == ITestResult.FAILURE) {
			logger.info("***********************   TEST CASE IS FAILURE!   ***********************");
		}else logger.info("***********************   TEST CASE IS SKIPPED!   ***********************");
		Log.endTestCase();
	}
}
