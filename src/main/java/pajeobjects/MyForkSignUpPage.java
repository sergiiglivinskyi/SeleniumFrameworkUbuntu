package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MyForkSignUpPage extends BaseMain{


    //Expected and Actual data
    String expectedTitle = "Sign Up";
    String actualTitle;
    int expectedDropDownListSize = 14;
    int actualDropDownListSize;
    Boolean isTermsConditionsTextCorrect;
    String termsAndConditionsText = "Agree with Terms and Conditions";

    //GUI elements XPaths
    String termsAndConditions = "//div[@class='auth-page-agree-terms-text']";

    public MyForkSignUpPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //Web Elements
    private WebElement jobTitleDropdownElement;
    private WebElement termsAndConditionsElement;

    //Dropdown
    private Select jobTitleDropdown;

    //List of dropdown options
    private List<WebElement> dropdownOptions;

    //List of expected roles from requirements
    private List<String> jobTitles = new ArrayList<>();

    //List of roles that are not implemented
    private List<String> notImplementedRoles = new ArrayList<>();

    //List of roles that implemented and are not matched with requirements
    private List<String> jobTitlesFromDropDown = new ArrayList<>();

    //Assign dropdown element and get the list of dropdown options
    private void setDropdownValues() {
        jobTitleDropdownElement = driver.findElement(By.id("job-title"));
        jobTitleDropdown = new Select(jobTitleDropdownElement);
        dropdownOptions = jobTitleDropdown.getOptions();
    }

    //Get and print all dropdown options (HOMEWORK)
    public void getJobTitleDropdownValues() {
        setDropdownValues();
        for (WebElement dropdownOption: dropdownOptions) {
            System.out.println("Role name: " + dropdownOption.getText());
        }
    }

    //Verify what has been implemented correctly (ADDITIONAL IMPLEMENTATION)
    public void validateCorrectnessOfImplementation() {
        setDropdownValues();
        setExpectedRoleValues();
        setNewListWithDropdownOptions();
        //Fill the additional list with requirements values
        notImplementedRoles.addAll(jobTitles);

        //Verify if there are values are not implemented from requirements
        for (WebElement dropdownOption: dropdownOptions) {
            for(int i = 0; i < notImplementedRoles.size(); i++){
                if(dropdownOption.getText().equals(notImplementedRoles.get(i))){
                    notImplementedRoles.remove(i);
                }
            }
        }

        //Verify if there are values are implemented and are not matched with the requirements
        for(String jobTitle: jobTitles) {
            for(int i = 0; i < jobTitlesFromDropDown.size(); i++){
                if(jobTitle.equals(jobTitlesFromDropDown.get(i))){
                    jobTitlesFromDropDown.remove(i);
                }
            }
        }

        //Print the results
        if(notImplementedRoles.size() == 0){
            System.out.println("Success! All dropdown options have been implemented correctly");
        }else {
            System.out.println("List of roles that are not implemented: " + notImplementedRoles);
        }


        if(jobTitlesFromDropDown.size() == 0){
            System.out.println("Success! There are no values that are not matched with requirements in the dropdown");
        }else{
            System.out.println("List of roles that implemented and are not matched with requirements: " + jobTitlesFromDropDown);
        }
    }

    //Fill the new list with requirements values
    private void setExpectedRoleValues() {
        jobTitles.add("Junior level Developer");
        jobTitles.add("Middle level Developer");
        jobTitles.add("Senior level Developer");
        jobTitles.add("Leading Developer");
        jobTitles.add("QA Analyst");
        jobTitles.add("Software Tester");
        jobTitles.add("QA Engineer");
        jobTitles.add("Senior QA Engineer");
        jobTitles.add("Automation QA Engineer");
        jobTitles.add("Test Lead");
        jobTitles.add("Automation Test Lead");
        jobTitles.add("Business Analyst");
        jobTitles.add("Senior Business Analyst");
        jobTitles.add("Designer");
    }

    //Fill the new list with implemented dropdown values
    private void setNewListWithDropdownOptions() {
        for (WebElement dropdownOption: dropdownOptions) {
            jobTitlesFromDropDown.add(dropdownOption.getText());
        }
    }

    private void setUpForAssertions(){
        //Page title
        actualTitle = driver.getTitle();

        //Terms and conditions element text
        termsAndConditionsElement = driver.findElement(By.xpath(termsAndConditions));
        if(termsAndConditionsElement.getText().equals(termsAndConditionsText)) {
            isTermsConditionsTextCorrect = true;
        }else {
            isTermsConditionsTextCorrect = false;
        }

        //Drop down options
        setDropdownValues();
        setExpectedRoleValues();
        setNewListWithDropdownOptions();
        actualDropDownListSize = dropdownOptions.size();
    }

    public void validateCorrectnessOfImplementationWithHardAssertions() {
        setUpForAssertions();

        //String - passed
        Assert.assertEquals(actualTitle, expectedTitle);
        //Boolean - passed
        Assert.assertTrue(isTermsConditionsTextCorrect);
        //int - passed
        Assert.assertEquals(actualDropDownListSize, expectedDropDownListSize);
        //List<String> - failed
        Assert.assertEquals(jobTitlesFromDropDown, jobTitles, "The requirements are not matched with implemented drop down options");
    }

    public void validateCorrectnessOfImplementationWithSoftAssertions() {
        expectedDropDownListSize = 10;
        termsAndConditionsText = "Agree";

        setUpForAssertions();
        SoftAssert softAssert = new SoftAssert();

        //String - passed
        softAssert.assertEquals(actualTitle, expectedTitle);
        //Boolean - failed
        softAssert.assertTrue(isTermsConditionsTextCorrect, "Terms and Conditions text is incorrect");
        //int - failed
        softAssert.assertEquals(actualDropDownListSize, expectedDropDownListSize, "Drop down list size is different");
        //List<String> - failed
        softAssert.assertEquals(jobTitlesFromDropDown, jobTitles, "The requirements are not matched with implemented drop down options");
        softAssert.assertAll();
    }
}