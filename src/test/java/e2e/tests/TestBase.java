package e2e.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setApp() {
        app.init();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        app.stop(result.isSuccess());
    }
}