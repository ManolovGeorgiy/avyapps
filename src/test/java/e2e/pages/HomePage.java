package e2e.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@class='LandingJoin_joinButton__GNwZp']")
    WebElement joinButton;

    @FindBy(xpath = "//*[@class='LandingNavBar_landingButtonV1__p1Wiy']")
    WebElement loginButton;

    // Локатор для контейнера футера
    @FindBy(xpath = "//*[@class='LandingFooter_landingFooterContainer__MuJ3q']")
    WebElement footerContainer;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Метод для ожидания загрузки элементов страницы
    public void waitForLoading() {
        try {
            getWait().forVisibility(joinButton);
            getWait().forVisibility(loginButton);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }

    // Метод для прокрутки страницы вниз
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    // Метод для прокрутки к элементу joinButton и его нажатия
    public void clickJoinButton() {
        scrollToElement(joinButton);
        joinButton.click();
    }

    // Метод для прокрутки к конкретному элементу
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Метод для прокрутки страницы до футера
    public void scrollToFooter() {
        scrollToElement(footerContainer);
    }
}
