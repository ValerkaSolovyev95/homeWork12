package github.tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class TestData {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE = 80;
    public static final SelenideElement
            searchButton = $(".header-search-button");
    public static final SelenideElement searchField = $("#query-builder-test");
    public static final SelenideElement issueTab = $("#issues-tab");
    public static final SelenideElement linkRepository = $(linkText(REPOSITORY));
}
