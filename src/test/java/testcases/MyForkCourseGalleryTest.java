package testcases;

import org.testng.annotations.Test;

public class MyForkCourseGalleryTest extends BaseTest {

    @Test
    public void historyAvailability() {
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkCourseGalleryPage.isHistoryDisplayed(false);
        myForkHomePage.goToMainPage();
        myForkHomePage.openSignInPage();
        myForkSignInPage.loginWithCredentials("testing@my-fork.com", "Password");
        myForkHomePage.openCourseGalleryPage();
        myForkCourseGalleryPage.isHistoryDisplayed(true);
    }

    @Test
    public void courseGalleryOptions() {
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkCourseGalleryPage.verifyAreaValues();
    }

    @Test
    public void quizProgressBarFunctionality() {
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkCourseGalleryPage.getNumberOfQuizQuestions();
        myForkCourseGalleryPage.clickOnStartButton();
        myForkCourseGalleryPage.switchToTab(1);
        myForkQuizPage.verifyQuizProgressBarForAllAnswers();
    }
}