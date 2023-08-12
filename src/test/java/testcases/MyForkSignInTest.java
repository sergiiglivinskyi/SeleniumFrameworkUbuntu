package testcases;

import org.testng.annotations.Test;

public class MyForkSignInTest extends BaseTest{

    @Test
    public void fillEmailAndPasswordFieldAndValidateError() {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignInPage();
        myForkSignInPage.fillEmailAndPasswordWithInvalidData();
        myForkSignInPage.verifyErrorMessage();
    }
}