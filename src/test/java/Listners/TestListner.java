package Listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListner implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(TestListner.class.getName());

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Test Started :"+result.getTestClass().getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test Passed :"+result.getTestClass().getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test Failed :"+result.getTestClass().getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Test Skipped :"+result.getTestClass().getTestName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
