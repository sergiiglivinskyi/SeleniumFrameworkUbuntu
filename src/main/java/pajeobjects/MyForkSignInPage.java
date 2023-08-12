package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

public class MyForkSignInPage extends BaseMain {
    public MyForkSignInPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    WebElement errorMessageElement;

    //GUI elements XPaths
    String btnLogin = "//button[@type='submit']";
    String errorMessage = "//span[@class='invalid-feedback']";

    public void fillEmailAndPasswordWithInvalidData() {
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath(btnLogin)).submit();
    }

    public void verifyErrorMessage() {
        errorMessageElement = driver.findElement(By.xpath(errorMessage));

        //Explicit wait implementation
        WebDriverWait waitForErrorMessageToLoad = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForErrorMessageToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessage)));

        boolean isErrorMessageCorrect = errorMessageElement.getText().equals("These credentials do not match our records.");
        String isErrorMessageCorrectText = isErrorMessageCorrect ? "Error message is correct" : "Error message is not correct";
        System.out.println(isErrorMessageCorrectText);
        System.out.println("Error message: " + errorMessageElement.getText());
        Assert.assertTrue(isErrorMessageCorrect);
    }

    public void loginWithCredentials(String email, String password) {
        typeUsingId("email", "Email text field", email);
        typeUsingId("password", "Password text field", password);
        clickUsingXpath(btnLogin, "Login button");
    }
}