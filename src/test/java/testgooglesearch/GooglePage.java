package testgooglesearch;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    private static final String SEARCH_FIELD = "#APjFqb";
    private static final String RESULT_PAGE = "#search";

    public void openPage() {
        //Открываем страницу
        open("/");
    }

    public void setValueInSearchField(String value) {
        //Вводим в строку поиска VALUE
        $(SEARCH_FIELD).setValue(value).pressEnter();
    }

    public void openTheFirstLink(String value) {
        //Проверяем что появилась страница
        $(RESULT_PAGE).shouldBe(Condition.visible);
        //Проверяем что результат поиска соответствует VALUE
        $(RESULT_PAGE).shouldHave(Condition.text(value));
        // Получить коллекцию ссылок и кликнуть на первую
        $$(".g").first().$("a").click();
    }

    public void checkThePageTitle(String titlePage) {
        //Проверяем что заголовок страницы содержит наш VALUE
        $("title").shouldHave(Condition.attribute("text", titlePage));
    }

    public void back() {
        //Возвращаемся на обратную страницу
        Selenide.back();
    }

    public void checkTheOldQueryInTheSearchField(String value) {
        //Проверяем что в поле поиска остался наш запрос
        $(SEARCH_FIELD).shouldHave(Condition.value(value));
    }
}
