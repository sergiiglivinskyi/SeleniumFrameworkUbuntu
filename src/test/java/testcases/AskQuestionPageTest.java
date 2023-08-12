package testcases;

import org.testng.annotations.Test;

public class AskQuestionPageTest extends BaseTest{

    @Test
    public void checkFillingQuestionFormWithAllFields() {
        myForkHomePage.openHomePage();
        myForkHomePage.clickAskQst();
        askQuestionPage.fillQuestionFormAllFields();
        askQuestionPage.validateThatAlertTextIsCorrect();
    }

    @Test
    public void checkFillingQuestionFormWithMandatoryFields() {
        myForkHomePage.openHomePage();
        myForkHomePage.clickAskQst();
        askQuestionPage.fillQuestionFormMandatoryFields();
        askQuestionPage.validateThatAlertTextIsCorrect();
    }
}