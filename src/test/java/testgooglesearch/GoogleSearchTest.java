package testgooglesearch;

import org.junit.jupiter.api.Test;

public class GoogleSearchTest extends BaseTest {
    private static final String VALUE = "Автоматизация тестирования";
    private static final String TITLE_PAGE = " Автоматизация тестирования DevOps | Atlassian ";


    GooglePage googlePage = new GooglePage();
    @Test
    public void testSearchGoogle() {
        googlePage.openPage();
        googlePage.setValueInSearchField(VALUE);
        googlePage.openTheFirstLink(VALUE);
        googlePage.checkThePageTitle(TITLE_PAGE);
        googlePage.back();
        googlePage.checkTheOldQueryInTheSearchField(VALUE);
    }


}
