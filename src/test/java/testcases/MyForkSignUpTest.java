package testcases;

import org.testng.annotations.Test;

public class MyForkSignUpTest extends BaseTest{

    @Test
    public void validateRoleDropdownContentWithHardAssertions() {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignUpPage();
        myForkSignUpPage.getJobTitleDropdownValues();
        //Added the hard assertions validation
        myForkSignUpPage.validateCorrectnessOfImplementationWithHardAssertions();
    }

    @Test
    public void verifyRoleDropdownContentWithSoftAssertions() {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignUpPage();
        myForkSignUpPage.getJobTitleDropdownValues();
        //Added the soft assertions verification
        myForkSignUpPage.validateCorrectnessOfImplementationWithSoftAssertions();
    }
}