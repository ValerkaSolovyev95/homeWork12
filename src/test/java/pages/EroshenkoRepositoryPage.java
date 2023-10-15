package pages;

import github.tests.TestData;

public class EroshenkoRepositoryPage {

    public EroshenkoRepositoryPage clickIssue() {
        TestData.issueTab.click();
        return this;
    }
}
