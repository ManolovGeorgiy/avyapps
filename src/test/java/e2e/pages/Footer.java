package e2e.pages;

import e2e.enums.FooterLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends BasePage{

    @FindBy(xpath = "//*[@class='LandingFooter_landingFooterContainer__MuJ3q']")
    WebElement footerContainer;

    @FindBy(xpath = "//*[@class='LandingFooter_footerLinks__j5YEK']")
    WebElement footerLinks;

    @FindBy(xpath = "//*[@class='LandingFooter_footerLinksIcons__UT51N']")
    WebElement footerIcons;

    public Footer(WebDriver driver) {
        super(driver);
    }

    // Метод для клика по кнопке в футере
    public void clickFooterButton(FooterLinks link) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), '" + link.getValue() + "')]"));
        button.click();
    }

    // Метод для клика по ссылке в футере
    public void clickFooterLink(FooterLinks link) {
        WebElement footerLink = driver.findElement(By.xpath("//a[contains(text(), '" + link.getValue() + "')]"));
        footerLink.click();
    }

    // Метод для клика по иконке социальной сети в футере
    public void clickFooterIcon(FooterLinks icon) {
        WebElement footerIcon = driver.findElement(By.xpath("//a[contains(@href, '" + icon.getValue().toLowerCase() + "')]"));
        footerIcon.click();
    }
}
