package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertionsSoftTest extends BaseTest{

    String expectedTitle = "Best";
    String actualTitle;
    String carouselList = "//span[text()='Trending now ']/../../../div[2]//ul/li";
    int listSizeActual;
    int listSizeExpected = 8;

    //Hard Assertions
    @Test(groups = {"assertions"})
    public void dropdown() {
        driver.get("https://www.bestbuy.com/");
        actualTitle = driver.getTitle();
        homePage.verticalScroll(2300);

        List<WebElement> elementList = driver.findElements(By.xpath(carouselList));
        listSizeActual = elementList.size();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle, expectedTitle, "Title is different");
        softAssert.assertEquals(listSizeActual, listSizeExpected, "Size did not matched");
        System.out.println("Proceed");

        softAssert.assertAll();

    }
}
