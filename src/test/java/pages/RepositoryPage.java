package pages;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class RepositoryPage {

    public RepositoryPage clickRepository(String repo) {
        $(linkText(repo)).click();
        return this;
    }
}
