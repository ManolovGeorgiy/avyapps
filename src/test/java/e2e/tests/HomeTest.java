package e2e.tests;

import e2e.enums.FooterLinks;
import e2e.enums.LandingNavBar;
import e2e.pages.Footer;
import e2e.pages.Header;
import e2e.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends TestBase{

    HomePage homePage;
    Header header;
    Footer footer;

    @Test
    public void homeTest(){
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.scrollToFooter();
        footer = new Footer(app.driver);
        footer.clickFooterButton(FooterLinks.ABOUT);
        homePage = new HomePage(app.driver);
        homePage.scrollDown();
        homePage.clickJoinButton();
    }
}
