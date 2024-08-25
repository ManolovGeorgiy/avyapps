package e2e.pages;

import e2e.pages.BasePage;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {



    @FindBy(xpath = "//*[@class='LandingNavBar_navWrapper__3FrCD']")
    WebElement header;
    @FindBy(xpath = "//*[@class='LandingNavBar_landingButtonV1__p1Wiy']")
    WebElement loginButton;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitForLoading() {
        try {
            getWait().forVisibility(header);
            getWait().forVisibility(loginButton);
        } catch (StaleElementReferenceException e) {
        }
    }

    public  void clickButton(){
        loginButton.click();
    }
}
