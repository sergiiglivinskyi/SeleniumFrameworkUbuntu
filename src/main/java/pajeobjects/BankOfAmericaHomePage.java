package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BankOfAmericaHomePage extends BaseMain{

    public BankOfAmericaHomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //URL
    String urlBankOfAmerica = "https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG";

    //GUI elements XPaths
    String topicEverydayBanking = "//a[@name='Everyday_Banking']";
    String btnClose = "//button[@id='nextBtnSubTopic']/preceding-sibling::button";
    String btnNext = "//button[@id='nextBtnSubTopic']";

    public void openWebsite(){
        driver.get(urlBankOfAmerica);
    }

    public void openTopicEverydayBanking() {
        driver.findElement(By.xpath(topicEverydayBanking)).click();
    }

    public void areButtonsEnabled() {
        System.out.println("Close button is enabled: " + driver.findElement(By.xpath(btnClose)).isEnabled());
        System.out.println("Next button is enabled: " + driver.findElement(By.xpath(btnNext)).isEnabled());
    }
}