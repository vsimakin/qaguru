package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBankTests {

    @BeforeEach
    public void openPageYandexMarket(){
        Configuration.startMaximized = true;
        open("https://alfabank.ru/");
    }

    @Test
    public void checkArchiveDeposits(){
        $(byText("Вклады")).click();
        $("a[title='Депозиты']").click();
        $(byText("Архивные депозиты")).click();
        $$x("//div[@class='col-xs-10 product-cell__cell-box']/div").shouldHave(CollectionCondition.size(3));
    }
}
