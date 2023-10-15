package github.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class SelenideTest extends BaseTest {

    @Test
    void selenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        mainPage
                .openMainPage("")
                .findRepository(TestData.REPOSITORY);
        repositoryPage.clickRepository(TestData.REPOSITORY);
        eroshenkoRepositoryPage.clickIssue();
        issuesPage.shouldSeeIssueWithNumber(80);
    }
}
