package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DriverInteractionsTest extends BaseTest {
    @Test(priority = 2, groups = {"driver"})
    public void test1() {
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("keyboard");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        String urlVerify = driver.getCurrentUrl();
        System.out.println(urlVerify);
        String title = driver.getTitle();
        System.out.println(title);
    }

    @Test(priority = 1, groups = {"driver"})
    public void test2() {
        driver.get("https://www.amazon.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(0));
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("keyboard");
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        driver.switchTo().window(tabHandler.get(4));
        driver.navigate().to("https://www.bestbuy.com/");
    }

    @Test
    public void test3() {
        driver.get("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,3000)", "");
    }
}
