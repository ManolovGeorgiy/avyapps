package e2e.tests;

import e2e.enums.LandingNavBar;
import e2e.pages.Header;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    HomePage homePage;
    Header header;
    LoginPage loginPage;
    @Test()
    public void loginClickButton(){
        String email = "tatar@abv.bg";
        String password = "tatar";

        header = new Header(app.driver);
        header.clickLoginButton();

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.emailAndPassword(email,password);
        loginPage.clickLoginButton();
    }
}
