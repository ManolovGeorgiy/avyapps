package e2e.pages;

import e2e.enums.LandingNavBar;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Header extends BasePage{

    @FindBy(xpath = "//*[@class='LandingNavBar_navWrapper__3FrCD']")
    WebElement headerList;
    @FindBy(xpath = "//*[@class='LandingNavBar_landingLinks__Mr5U7']")
    WebElement headerMenu;
    @FindBy(xpath = "//*[@class='LandingNavBar_logo__5rC6S']")
    WebElement logo;
    @FindBy(xpath = "//*[@class='LandingNavBar_landingButtonV1__p1Wiy']")
    WebElement loginButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    @Step("Wait for loading Header")
    public void waitForLoading() {
        try {
            getWait().forVisibility(headerMenu);
            getWait().forVisibility(headerList);
            Assert.assertTrue(headerList.isDisplayed());
            getWait().forVisibility(logo);
            getWait().forVisibility(loginButton);
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void tabHeaderMenu(LandingNavBar tab) {
        WebElement option = driver.findElement(By.xpath("//*[@class='LandingNavBar_landingLinks__Mr5U7' and text()='" + tab.value + "']"));
        getWait().forVisibility(headerMenu);
        getWait().forVisibility(option);
        option.click();
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
