package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AddDemoForm extends BasePage {

    @FindBy(xpath = "//*[@placeholder='Name']")
    WebElement nameInput;

    @FindBy(xpath = "//*[@placeholder='Company Name']")
    WebElement nameCompanyInput;

    @FindBy(xpath = "//*[@placeholder='Email']")
    WebElement emailInput;

    @FindBy(xpath = "//*[@placeholder='Phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//*[@class='ReactFlagsSelect-module_selectBtn__19wW7']")
    WebElement countryDropdownButton;

    @FindBy(xpath = "//*[@class='ReactFlagsSelect-module_listOption__2lctj']")
    List<WebElement> countryOptions;

    @FindBy(xpath = "//*[@placeholder='Employee size']")
    WebElement employeeSizeInput;

    @FindBy(xpath = "//*[@placeholder='Message']")
    WebElement messageInput;

    @FindBy(xpath = "//*[@class='LandingForm_formButton__dvhs7']")
    WebElement bookADemoButton;

    public AddDemoForm(WebDriver driver) {
        super(driver);
    }

    @Step("Wait for loading Edit profile page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(nameInput);
            getWait().forVisibility(nameCompanyInput);
            getWait().forVisibility(emailInput);
            getWait().forVisibility(phoneInput);
            getWait().forVisibility(countryDropdownButton);
            getWait().forVisibility(employeeSizeInput);
            getWait().forVisibility(messageInput);
            getWait().forVisibility(bookADemoButton);
        } catch (StaleElementReferenceException e) {
            // Handle exception
        }
    }

    @Step("Select country: {country}")
    public void selectCountry(String country) {
        countryDropdownButton.click();
        // Поиск страны в выпадающем списке
        for (WebElement option : countryOptions) {
            if (option.getText().equalsIgnoreCase(country)) {
                option.click();
                break;
            }
        }
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    @Step("Fill demo form")
    public void setPostForm(String name, String company, String email, String phone, String country, String message) {
        nameInput.sendKeys(name);
        nameCompanyInput.sendKeys(company);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        selectCountry(country);  // Вызов нового метода для выбора страны
        messageInput.sendKeys(message);
    }

    public void clickDemoButton() {
        bookADemoButton.click();
    }
}