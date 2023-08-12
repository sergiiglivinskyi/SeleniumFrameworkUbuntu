package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.logging.Logger;

public class AskQuestionPage extends BaseMain {

    By questionInput = By.xpath("//input[@name='question']");
    By answerInput = By.xpath("//input[@name='answer']");
    By emailInput = By.xpath("//input[@name='email']");
    By submitBtn = By.xpath("//input[@type='submit']");
    By alert = By.xpath("//div[@class='share-question-titles-block']/span[@role='alert']");

    public AskQuestionPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void fillQuestionFormAllFields() {
        driver.findElement(questionInput).sendKeys("I got error when I click submit button. Please advise");
        driver.findElement(answerInput).sendKeys("I do not know");
        driver.findElement(emailInput).sendKeys("bolotova.katya@gmail.com");
        driver.findElement(submitBtn).click();
    }


    public void fillQuestionFormMandatoryFields() {
        driver.findElement(questionInput).sendKeys("I got error when I click submit button. Please advise");
        driver.findElement(emailInput).sendKeys("bolotova.katya@gmail.com");
        driver.findElement(submitBtn).click();
    }

    public String getAlertText(){
        return driver.findElement(alert).getText();
    }

    public void validateThatAlertTextIsCorrect() {
        Assert.assertEquals(getAlertText(), "The title field is required.");
        log.info("Alert Validation passed successfully. Alert Text values are the same");
    }
}