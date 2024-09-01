package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddDemoForm extends BasePage{

    @FindBy(xpath = "//*[@placeholder='Name']")
    WebElement nameInput;
    @FindBy(xpath = "//*[@placeholder='Company Name']")
    WebElement nameCompanyInput;
    @FindBy(xpath = "//*[@placeholder='Email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@placeholder='Phone']")
    WebElement phoneInput;
    @FindBy(xpath = "//*[@class='LandingForm_countryInput__lJl1W']")
    WebElement countryInput;
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
            getWait().forVisibility(countryInput);
            getWait().forVisibility(employeeSizeInput);
            getWait().forVisibility(messageInput);
            getWait().forVisibility(bookADemoButton);
        } catch (StaleElementReferenceException e) {
        }
    }
    @Step("Fill demo form")
    public void setPostForm(String name, String company, String email, String phone,String country,String message) {
        nameInput.sendKeys(name);
        nameCompanyInput.sendKeys(company);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        messageInput.sendKeys(message);
    }
    public void clickDemoButton(){
        bookADemoButton.click();
    }
}
