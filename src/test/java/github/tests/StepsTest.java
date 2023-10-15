package github.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest extends BaseTest {

    @Test
    void testLambdaStep() {
        step("Открываем главную страницу", () -> open(""));
        step("Ищем репозиторий " + TestData.REPOSITORY, () -> {
            TestData.searchButton.click();
            TestData.searchField.sendKeys(TestData.REPOSITORY);
            TestData.searchField.submit();
        });
        step("Кликаем по ссылке репозитория " + TestData.REPOSITORY, () -> TestData.linkRepository.click());
        step("Открываем таб Issues", () -> TestData.issueTab.click());
        step("Проверяем наличие Issue с номером " + TestData.ISSUE, () -> {
            $(withText("#" + TestData.ISSUE)).should(Condition.exist);
        });
    }

    @Test
    void testAnnotatedStep() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(TestData.REPOSITORY);
        steps.clickOnRepositoryLink();
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(TestData.ISSUE);
    }
}
