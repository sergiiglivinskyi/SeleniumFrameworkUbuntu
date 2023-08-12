package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AssertionsTest extends BaseTest{

    String expectedTitle = "Amazon ClinicW";
    String actualTitle;
    String carouselList = "//span[text()='Trending now ']/../../../div[2]//ul/li";
    int listSizeActual;
    int listSizeExpected = 8;

    //Hard Assertions
    @Test(groups = {"driver"})
    public void dropdown() {
        driver.get("https://www.bestbuy.com/");
        actualTitle = driver.getTitle();

//        Assert.assertEquals(actualTitle, expectedTitle);
//        System.out.println("Title is correct");

        Assert.assertNotEquals(actualTitle, expectedTitle);
        System.out.println("Title is different");
        homePage.verticalScroll(2300);

        List<WebElement> elementList = driver.findElements(By.xpath(carouselList));
        listSizeActual = elementList.size();

        Assert.assertEquals(listSizeActual, listSizeExpected, "Did not matched");

    }
}
