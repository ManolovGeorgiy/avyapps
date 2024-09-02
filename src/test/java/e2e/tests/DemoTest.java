package e2e.tests;

import com.github.javafaker.Faker;
import e2e.enums.FooterLinks;
import e2e.pages.AddDemoForm;
import e2e.pages.Footer;
import e2e.pages.Header;
import e2e.pages.HomePage;
import org.testng.annotations.Test;

public class DemoTest extends TestBase{

    Faker faker = new Faker();
    HomePage homePage;
    Footer footer;
    AddDemoForm addDemoForm;

    @Test
    public void homeTest(){

        String name = "Georg";
        String nameCompany = "Georg";
        String email = "g@gmail.com";
        String phone = "+1234567";
        String country = "Albania";
        String message = faker.lorem().sentence(50);

        // Инициализация страниц
        homePage = new HomePage(app.driver);
        footer = new Footer(app.driver);
        addDemoForm = new AddDemoForm(app.driver);

        // Ожидание загрузки страницы и прокрутка до футера
        homePage.waitForLoading();
        homePage.scrollToFooter();

        // Клик по кнопке "Demo" в футере
        footer.clickFooterButton(FooterLinks.DEMO);

        // Заполнение и отправка формы демо
        addDemoForm.waitForLoading();
        addDemoForm.setPostForm(name, nameCompany, email, phone, country, message);
        addDemoForm.clickDemoButton();

        // Дополнительные действия
        homePage.scrollDown();
        homePage.clickJoinButton();
    }
}