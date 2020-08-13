package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class YandexTests {
    @Test
    void selenideSearchTest() {
        // Открыть google
        open("https://yandex.ru");

        // Ввести Selenide в поиск
        $(byName("text")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("ru.selenide.org"));
    }

    @Test
    void dockerSearchTest() {
        // Открыть google
        open("https://ya.ru");

        // Ввести Selenide в поиск
        $(byName("text")).setValue("Docker").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $("html").shouldHave(text("docker.com"));
    }
}
