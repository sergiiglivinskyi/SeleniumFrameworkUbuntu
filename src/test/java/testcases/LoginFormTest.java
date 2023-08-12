package testcases;

import org.testng.annotations.Test;

public class LoginFormTest extends BaseTest {
    @Test
    public void openSignInPage() {
        homePage.clickSignIn();
    }
    @Test(priority = 3, groups = {"login"})
    public void fillEmailAndPasswordFields() {
        homePage.clickSignIn();
        signInPage.fillTheSignInForm();
    }
    @Test(priority = 3, groups = {"login"})
    public void fillEmailAndPasswordFieldAndPressEnter() {
        homePage.clickSignIn();
        signInPage.loginWithPressEnter();
    }
    @Test(priority = 3, groups = {"login"})
    public void fillEmailAndPasswordFieldAndValidateError() {
        homePage.clickSignIn();
        signInPage.loginWithPressEnter();
        signInPage.isErrorMessageDisplayed();
    }
    @Test(priority = 2, groups = {"checkbox"})
    public void fillEmailAndPasswordFieldAndValidateCheckbox() {
        homePage.clickSignIn();
        signInPage.isCheckboxRememberMeSelected();
    }
    @Test(priority = 1, groups = {"checkbox"})
    public void verifyCheckBox() {
        homePage.clickSignIn();
        signInPage.verifyCheckboxRememberMeText();
    }
    @Test
    public void signIn() {
        homePage.clickSignIn();
        signInPage.signIn("test@test.com", "password");
    }
}