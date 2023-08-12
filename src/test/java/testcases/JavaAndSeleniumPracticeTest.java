package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class JavaAndSeleniumPracticeTest extends BaseTest {

    @Test
    public void closeAndQuit() {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']")).sendKeys(Keys.chord(Keys.COMMAND,Keys.ENTER));
        System.out.println();
    }
    @Test
    public void dropdown() {
        driver.get("https://www.amazon.com/");
        WebElement searchDropdownElement =  driver.findElement(By.id("searchDropdownBox"));
        Select searchDropdown = new Select(searchDropdownElement);
        List<WebElement> dropdownOptions = searchDropdown.getOptions();
//        dropdownOptions.get(2).click();
        for (WebElement dropdownOption : dropdownOptions) {
            if (dropdownOption.getText().equals("Computers")) {
                dropdownOption.click();
            }

        }

    }
}
