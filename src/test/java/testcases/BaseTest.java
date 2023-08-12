package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pajeobjects.*;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    WebDriver driver;
    Logger log;
    HomePage homePage;
    SignInPage signInPage;
    BankOfAmericaHomePage bankOfAmericaHomePage;
    MyForkHomePage myForkHomePage;
    MyForkSignUpPage myForkSignUpPage;
    MyForkSignInPage myForkSignInPage;
    MyForkCourseGalleryPage myForkCourseGalleryPage;
    MyForkQuizPage myForkQuizPage;
    AskQuestionPage askQuestionPage;

    @BeforeMethod(groups = {"checkbox", "login", "assertions", "driver"}, alwaysRun = true)
    public void startDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/serhii/Documents/SeleniumFramework/src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        log = Logger.getLogger(getClass().getName());
        saveLogs(log);

        homePage = new HomePage(driver, log);
        signInPage = new SignInPage(driver, log);
        bankOfAmericaHomePage = new BankOfAmericaHomePage(driver, log);
        myForkHomePage = new MyForkHomePage(driver, log);
        myForkSignUpPage = new MyForkSignUpPage(driver, log);
        myForkSignInPage = new MyForkSignInPage(driver, log);
        myForkCourseGalleryPage = new MyForkCourseGalleryPage(driver, log);
        myForkQuizPage = new MyForkQuizPage(driver, log);
        askQuestionPage = new AskQuestionPage(driver,log);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod(groups = {"checkbox", "login", "assertions", "driver"}, alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler = new FileHandler("/home/serhii/Documents/SeleniumFramework/MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("==================THIS IS THE BEGINNING OF THE TEST==================");
    }
}