package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyForkCourseGalleryPage extends BaseMain{
    public MyForkCourseGalleryPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //GUI elements XPaths
    private String history = "//a[text()='History']";
    private String areaList = "//div[contains(@class, 'expertise-areas-item')]";
    private String numberOfQuestions = "//span[text()='SQL 101 (Basics)']/../../../div[2]/div[@class='quiz-item-questions-count']";
    private String btnStart = "//span[text()='SQL 101 (Basics)']/../../../div[2]/a/div";

    //Locators
    private By historyLocator = By.xpath(history);
    private By areaListLocator = By.xpath(areaList);
    private By numberOfQuestionsLocator = By.xpath(numberOfQuestions);
    private By btnStartLocator = By.xpath(btnStart);

    //List of expected area values
    private List<String> expectedAreaValues = new ArrayList<>();

    //List of implemented area values
    private List<String> implementedAreaValuesString = new ArrayList<>();

    private static int numberOfQuizQuestions;

    public void isHistoryDisplayed(boolean isLoggedIn) {
        isElementDisplayedDependsOfLogin(historyLocator, isLoggedIn);
    }

    private void setExpectedAreaValues() {
        expectedAreaValues.add("Development");
        expectedAreaValues.add("Testing");
        expectedAreaValues.add("Business Analyst");
        expectedAreaValues.add("Agile");
        expectedAreaValues.add("Project Management");
    }

    public void verifyAreaValues() {
        setExpectedAreaValues();
        setListWithTextForImplementedValues(driver.findElements(areaListLocator), implementedAreaValuesString);
        validateListOfStringWithAssertEqual(implementedAreaValuesString, expectedAreaValues, "The area values have been implemented incorrectly");
    }

    public int getNumberOfQuizQuestions() {
        String numberInString = driver.findElement(numberOfQuestionsLocator).getText();
        String[] parts = numberInString.split("/");
        String questionsNumberInString = parts[1].trim();
        numberOfQuizQuestions = Integer.parseInt(questionsNumberInString);
        return numberOfQuizQuestions;
    }

    public void clickOnStartButton() {
        clickUsingXpath(btnStartLocator, "Start button on the Gallery Page");
    }

    public static int getNumberOfQuestions(){
        return numberOfQuizQuestions;
    }
}