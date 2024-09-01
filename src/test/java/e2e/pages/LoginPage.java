package e2e.pages;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@type='submit']")
    WebElement login;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void waitForLoading() {
        try {
            getWait().forVisibility(emailInput);
            getWait().forVisibility(passwordInput);
            getWait().forVisibility(login);
        } catch (StaleElementReferenceException e) {
        }
    }
    public  void emailAndPassword(String email,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        login.click();
    }

}

