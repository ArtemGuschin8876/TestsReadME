package testgooglesearch;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    private static final String SEARCH_FIELD = "#APjFqb";
    private static final String RESULT_PAGE = "#search";

    public void openPage() {
        open("/");
    }

    public void setValueInSearchField(String value) {
        $(SEARCH_FIELD).setValue(value).pressEnter();
    }

    public void openTheFirstLink(String value) {
        $(RESULT_PAGE).shouldBe(Condition.visible);
        $(RESULT_PAGE).shouldHave(Condition.text(value));
        $$(".g").first().$("a").click();
    }

    public void checkThePageTitle(String titlePage) {
        $("title").shouldHave(Condition.attribute("text", titlePage));
    }

    public void back() {
        Selenide.back();
    }

    public void checkTheOldQueryInTheSearchField(String value) {
        $(SEARCH_FIELD).shouldHave(Condition.value(value));
    }
}
