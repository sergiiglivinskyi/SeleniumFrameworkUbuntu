package testcases;

import org.testng.annotations.Test;

public class EverydayBankingTest extends BaseTest{

    @Test
    public void isEnabled() {
        bankOfAmericaHomePage.openWebsite();
        bankOfAmericaHomePage.openTopicEverydayBanking();
        bankOfAmericaHomePage.areButtonsEnabled();
    }
}
