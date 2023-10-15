package github.tests;

import org.junit.jupiter.api.Test;

public class SelenideTest extends BaseTest {

    @Test
    void selenideTest() {
        mainPage
                .openMainPage("")
                .findRepository(TestData.REPOSITORY);
        repositoryPage.clickRepository(TestData.REPOSITORY);
        eroshenkoRepositoryPage.clickIssue();
        issuesPage.shouldSeeIssueWithNumber(80);
    }
}
