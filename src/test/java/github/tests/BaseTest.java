package github.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
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
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();
    }
}
