package e2e.pages;

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
    @FindBy(xpath = "//select[@placeholder='Phone']")
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
}
