package e2e.tests;

import e2e.enums.LandingNavBar;
import e2e.pages.Header;
import e2e.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends TestBase{

    HomePage homePage;
    Header header;

    @Test
    public void homeTest(){
        homePage = new HomePage(app.driver);
        header = new Header(app.driver);
        header.waitForLoading();
        header.tabHeaderMenu(LandingNavBar.ABOUT);
    }
}
