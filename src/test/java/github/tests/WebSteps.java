package github.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        TestData.searchButton.click();
        TestData.searchField.sendKeys(repo);
        TestData.searchField.submit();
    }

    @Step("Кликаем по ссылке репозитория eroshenkoam/allure-example")
    public void clickOnRepositoryLink() {
        TestData.linkRepository.click();
    }

    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        TestData.issueTab.click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
