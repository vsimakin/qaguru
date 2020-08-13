package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexMarketTests {

    @BeforeEach
    public void openPageYandexMarket(){
        Configuration.startMaximized = true;
        open("https://market.yandex.ru/");
    }

    @Test
    public void checkSearchSamsungS20(){
        $(byName("text")).setValue("Samsung S20").pressEnter();
        $$("div[data-zone-name='snippetList'] article").shouldHave(sizeGreaterThanOrEqual(1));
    }

    @Test
    public void checkAddToFavouritesSamsungS20(){
        $(byName("text")).setValue("Samsung S20").pressEnter();
        $(By.xpath("//div[contains(@aria-label,'сравнению')]")).click();
        $(By.xpath("//span[text()='Сравнение']/preceding-sibling::span/child::span")).shouldHave(text("1"));
    }

    @Test
    public void checkLinkMyPublications(){
        $(By.xpath("//span[text()='Мои публикации']")).click();
        $(By.xpath("//h1[text()='Мои публикации']")).shouldHave(visible);
    }

    @Test
    public void checkSelectOtherRegion(){
        $("button[data-tid='e1c9fd84 206eb86b 510ec896']").click();
        $("input[placeholder='Укажите другой регион'").setValue("Пенза");
        $("div[data-tid='a0b3ebc1'").click();
        $x("//span[text()='Продолжить с новым регионом']/parent::button").click();
        $x("//span[text()='Пенза']").shouldBe(text("Пенза"));
    }

    @Test
    public void checkAuthorizationFormHaveGoogleAccount(){
        $x("//span[text()='Войти']/parent::a").click();
        switchTo().window(1);
        $x("//span[@class='passp-social-block__list-item-icon passp-social-block__list-item-icon_gg']").shouldBe(enabled);
    }

}
