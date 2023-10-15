package pages;

import github.tests.TestData;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openMainPage(String url) {
        open(url);
        return this;
    }

    public MainPage findRepository(String repo) {
        TestData.searchButton.click();
        TestData.searchField.sendKeys(repo);
        TestData.searchField.submit();
        return this;
    }
}
