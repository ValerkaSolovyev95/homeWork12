package github.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pages.EroshenkoRepositoryPage;
import pages.IssuesPage;
import pages.MainPage;
import pages.RepositoryPage;

public class BaseTest {

    MainPage mainPage = new MainPage();
    RepositoryPage repositoryPage = new RepositoryPage();
    EroshenkoRepositoryPage eroshenkoRepositoryPage = new EroshenkoRepositoryPage();
    IssuesPage issuesPage = new IssuesPage();

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void closeBrowser() {
        Attach.takeScreenshot("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
