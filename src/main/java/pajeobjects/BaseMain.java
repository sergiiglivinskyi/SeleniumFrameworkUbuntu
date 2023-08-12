package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {
    public WebDriver driver;
    public Logger log;

    public BaseMain(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.log = logger;
    }

    public void switchToTab(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    public void verticalScroll(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
    }

    public void isElementDisplayedDependsOfLogin(By locator, boolean isLoggedIn) {
        if (isLoggedIn) {
            validateBooleanWithAssertTrue(driver.findElement(locator).isDisplayed());
        } else {
            validateBooleanWithAssertTrue(driver.findElements(locator).isEmpty());
        }
    }

    public void setListWithTextForImplementedValues(List<WebElement> webElements, List<String> implementedValuesInText) {
        for(WebElement element : webElements) {
            implementedValuesInText.add(element.getText());
        }
    }

    public void clickUsingXpath(String xpath, String elementName) {
        driver.findElement(By.xpath(xpath)).click();
        log.info("Element: " + elementName + " was successfully clicked");
    }

    public void clickUsingXpath(By xpath, String elementName) {
        driver.findElement(xpath).click();
        log.info("Element: " + elementName + " was successfully clicked");
    }

    public void clickUsingWebElement(WebElement element, String elementName) {
        element.click();
        log.info("Element: " + elementName + " was successfully clicked");
    }

    public void typeUsingXpath(String xpath, String elementName, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value: " + value + " was successfully entered into " + elementName + " element");
    }

    public void typeUsingId(String id, String elementName, String value) {
        driver.findElement(By.id(id)).sendKeys(value);
        log.info("Value: " + value + " was successfully entered into " + elementName + " element");
    }

    public void validateBooleanWithAssertTrue(Boolean statement) {
        Assert.assertTrue(statement);
        log.info("Validation passed successfully");
    }

    public void validateListOfStringWithAssertEqual(List<String> actualValue, List<String> expectedValue) {
        Assert.assertEquals(actualValue, expectedValue);
        log.info("Validation passed successfully. Lists are equal");
    }

    public void validateListOfStringWithAssertEqual(List<String> actualValue, List<String> expectedValue, String errorMessage) {
        Assert.assertEquals(actualValue, expectedValue, errorMessage);
        log.info("Validation passed successfully. Lists are equal");
    }

    public void validateIntWithAssertEqual(int actualValue, int expectedValue) {
        Assert.assertEquals(actualValue, expectedValue);
        log.info("Validation passed successfully. Integer values are the same");
    }


    //HTTP REQUESTS
    public List<Integer> verifyLinkActive(){

        List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>(); //this List will have actual URLs
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        int resultCode; //initialize variable for a resulting code value and providing default value

        for (WebElement linkElement: linkElements){ //this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            collectedURLs.add(linkElement.getAttribute("href"));
        }


        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return codes; //a return of a list with codes for further verification
    }




}