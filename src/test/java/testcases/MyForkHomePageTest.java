package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyForkHomePageTest extends BaseTest{

    @Test
    public void urlVerification() {
        myForkHomePage.openWebsite();
        List<Integer> codes = myForkHomePage.urlVerification();

        SoftAssert softAssert = new SoftAssert();
        for(Integer code : codes) {
            softAssert.assertEquals(code, (Integer) 200);
            softAssert.assertAll();
        }
    }
}
