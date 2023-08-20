
# __Тренировка создания Readme файла, на примере простого теста.__

### __Простой автотест на поиск в Google.__

---
### Шаги:
* 1.Открыть страницу 
* 2.Ввести в строку поиска значение
  * ("Автоматизация тестирования")
* 3.Проверить что страница появилась
  * 3.1. Проверить что результат поиска соответствует значению
    ("Автоматизация тестирования")
  * 3.2 .Получить коллекцию ссылок и кликнуть на первую
* 4.Проверить что заголовок открытой страницы соответствует
  * " Автоматизация тестирования DevOps | Atlassian "
* 5.Возвращаемся обатно на страницу Google
* 6.Проверяем что в поле поиска остался наш запрос
  * ("Автоматизация тестирования")
---
### __1. Открыть страницу.__
````java
 public void openPage() {    
        open("/");
    }
````
_Так как у нас уже есть URL страницы Google в классе конфигурации, вместо ссылки в методе "open()", вставляется "/"._
````java
  @BeforeAll
    static void setUp(){
     Configuration.baseUrl = 
     "https://www.google.com/";
    }
````
_От класса конфигурации, наследуется гланый тестовый класс._

---
### __2.Ввести в строку поиска значение:__
("Автоматизация тестирования").
```java
public void setValueInSearchField(String value) {
        $(SEARCH_FIELD).setValue(value).pressEnter();
    }
```
---
### __3.Проверить что страница появилась__
_Шаги с 3, 3.1 и 3.2 включительно выполняются в одном методе._
````java
public void openTheFirstLink(String value) {
        $(RESULT_PAGE).shouldBe(Condition.visible);
        $(RESULT_PAGE).shouldHave(Condition.text(value));
        $$(".g").first().$("a").click();
    }
````
---

### __4.Проверить что заголовок открытой страницы соответствует:__
(" Автоматизация тестирования DevOps | Atlassian ")
````java
public void checkThePageTitle(String titlePage) {
        
        $("title").shouldHave(Condition.attribute("text", titlePage));
    }
````
---
### __5.Возвращаемся обатно на страницу Google.__
````java
public void back() {
        Selenide.back();
    }
````
---
### __6.Проверяем что в поле поиска остался наш запрос:__
("Автоматизация тестирования")
````java
public void checkTheOldQueryInTheSearchField(String value) {
        $(SEARCH_FIELD).shouldHave(Condition.value(value));
    }
````
---

## __И демонстрация всего теста в главном тестовом классе:__
#### _Уже после рефакторинга._
````java
   @Test
    public void testSearchGoogle() {
        googlePage.openPage();
        googlePage.setValueInSearchField(VALUE);
        googlePage.openTheFirstLink(VALUE);
        googlePage.checkThePageTitle(TITLE_PAGE);
        googlePage.back();
        googlePage.checkTheOldQueryInTheSearchField(VALUE);
    }
````
---

> private static final String VALUE = "Автоматизация тестирования";

> private static final String TITLE_PAGE = " Автоматизация тестирования DevOps | Atlassian ";
---

[Ссылка на репозиторий Selenide](https://github.com/selenide/selenide)

---
## __Спасибо.__

---
Это был мой первый опыт создания Readme файла для GitHub.
В последующих репозиториях я постараюсь и дальше постигать синтаксис "Markdown".

