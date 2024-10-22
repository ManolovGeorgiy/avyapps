package e2e.tests;

import com.github.javafaker.Faker;
import e2e.enums.FooterLinks;
import e2e.enums.LandingNavBar;
import e2e.pages.AddDemoForm;
import e2e.pages.Footer;
import e2e.pages.Header;
import e2e.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends TestBase{

    Faker faker = new Faker();
    HomePage homePage;
    Header header;
    Footer footer;
    AddDemoForm addDemoForm;

    @Test
    public void homeTest(){
        String name = "Georg";
        String nameCompany = "Georg";
        String email = "g@gmail.com";
        String phone = "+1234567";
        String country = "France";
        String message = faker.lorem().sentence(50);

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.scrollToFooter();
        footer = new Footer(app.driver);
        footer.clickFooterButton(FooterLinks.ABOUT);
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.scrollToFooter();
        footer = new Footer(app.driver);
        footer.clickFooterButton(FooterLinks.DEMO);
        homePage = new HomePage(app.driver);
        addDemoForm = new AddDemoForm(app.driver);
        addDemoForm.setPostForm(name,nameCompany,email,country,phone,message);
        addDemoForm.clickDemoButton();
        homePage.scrollDown();
        homePage.clickJoinButton();
    }
}
