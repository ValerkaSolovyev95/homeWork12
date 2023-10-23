package github.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.EroshenkoRepositoryPage;
import pages.IssuesPage;
import pages.MainPage;
import pages.RepositoryPage;

import java.util.Map;

public class BaseTest {

    MainPage mainPage = new MainPage();
    RepositoryPage repositoryPage = new RepositoryPage();
    EroshenkoRepositoryPage eroshenkoRepositoryPage = new EroshenkoRepositoryPage();
    IssuesPage issuesPage = new IssuesPage();

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://github.com";
        Configuration.remote = System.getProperty("remote_url");
        Configuration.browserSize = System.getProperty("browser_size", "1920X1280");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addLogger() {
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
