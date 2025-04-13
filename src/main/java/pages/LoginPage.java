package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By flashMessage = By.className("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFlashMessageText() {
        return driver.findElement(flashMessage).getText();
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElement(flashMessage).isDisplayed();
    }
}
