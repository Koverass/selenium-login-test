package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
        String message = loginPage.getFlashMessageText();

        assertTrue(message.contains("You logged into a secure area!"),
                "Expected login success message, got: " + message);
    }

    @Test
    public void testInvalidLogin() {
        loginPage.login("tomsmith", "WrongPassword!");
        String message = loginPage.getFlashMessageText();

        assertTrue(message.contains("Your password is invalid!"),
                "Expected login failure message, got: " + message);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}