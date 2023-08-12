package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.logging.Logger;

public class MyForkHomePage extends BaseMain{
    By askQst = By.xpath("//div[@class='home-head-content-left-share-question-button-text']");

    public MyForkHomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //URLs
    String urlMyFork = "https://test.my-fork.com/";
//    String urlMyFork = "https://netflix.com";
    String baseUrl = "https://test.my-fork.com/";

    //GUI elements XPaths
    String btnSignUp = "//div[@id='sign-up-button']/..";
    String btnSignIn = "//div[@id='log-in-button']/..";
    String linkCourseGallery = "//div[text()='Course Gallery']/..";

    public void openWebsite() {
        driver.get(urlMyFork);
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }
    public void openSignUpPage() {
        clickUsingXpath(btnSignUp, "Sign Up button");
    }

    public void openSignInPage() {
        clickUsingXpath(btnSignIn, "Sign In button");
    }

    public void openCourseGalleryPage() {
        clickUsingXpath(linkCourseGallery, "Course Gallery link");
    }

    public void goToMainPage() {
        driver.get(urlMyFork);
    }

    public List<Integer> urlVerification() {
        return verifyLinkActive();
    }

    public void clickAskQst(){
        driver.findElement(askQst).click();
    }

}
