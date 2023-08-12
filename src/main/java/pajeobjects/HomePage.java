package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class HomePage extends BaseMain{

    public HomePage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //URLs
    String urlBestBuy = "https://bestbuy.com";

    //GUI elements XPaths
    String btnAccount = "//button[@id='account-menu-account-button']";
    String btnSignInMainPage = "//a[text()='Sign In']";

    public void clickSignIn(){
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        WebDriverWait waitForDropdownToLoad = new WebDriverWait(driver, Duration.ofSeconds(20));
        waitForDropdownToLoad.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(btnSignInMainPage)));
        driver.findElement(By.xpath(btnSignInMainPage)).click();
    }
}