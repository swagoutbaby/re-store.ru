package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PageWithHome {

    private final SelenideElement
            cookieBtn = $(".cookie-agreement").$(byTagAndText("button", "Хорошо")),
            header = $(".header"),
            mainBanner = $(".section-slider"),
            categories = $(".section-categories"),
            bestsellers = $(".section-brands"),
            couldBeUseful = $("#gf-wrapper-recs-gf-hp-1"),
            popularItems = $("#gf-wrapper-recs-gf-hp-2"),
            sectionEcosystem = $(".section-ecosystem"),
            sectionBlog = $(".section-products"),
            lowestFooter = $(".prerender-footer"),
            chatPage = $("[component='ChatTab']"),
            product = $(".product-card--hovered"),
            bookingPage = $(".popmechanic-desktop");




    @Step("Открыть главную страницу")
    public PageWithHome openPage() {
        open("");
        Selenide.sleep(4500);
        return this;
    }

    @Step("Закрыть Cookie")
    public PageWithHome closeCookie() {
        if (cookieBtn.isDisplayed()) {
            cookieBtn.click();
        }
        return this;
    }

    @Step("Проверка элементов верхнего блока")
    public PageWithHome checkTopHeader(String element) {
        header.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения главного баннера")
    public PageWithHome checkMainBanner() {
        mainBanner.shouldBe(visible);
        return this;
    }

    @Step("Проверка отображения категорий товаров")
    public PageWithHome checkCategories(String element) {
        categories.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения блока бестселлеров")
    public PageWithHome checkBestsellers(String element) {
        bestsellers.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения блока 'Вам может пригодиться'")
    public PageWithHome checkCouldBeUseful(String element) {
        couldBeUseful.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения блока популярных товаров")
    public PageWithHome checkPopularItems(String element) {
        popularItems.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения блока экосистемы")
    public PageWithHome checkSectionEcosystem(String element) {
        sectionEcosystem.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения блока блога")
    public PageWithHome checkSectionBlog(String element) {
        sectionBlog.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения нижнего футера")
    public PageWithHome checkLowestFooter(String element) {
        lowestFooter.shouldHave(text(element));
        return this;
    }

    @Step("Проверка отображения элементов чата")
    public PageWithHome checkChatItems(String word) {
        $(".Uq2nE").shouldHave(text(word));
        return this;
    }

    @Step("Проверка отображения элементов диалога")
    public PageWithHome checkChatPage(String word) {
        chatPage.shouldHave(text(word));
        return this;
    }

    @Step("Выбрать продукт")
    public PageWithHome chooseProduct(String word) {
        product.click();
        return this;
    }

    @Step("Проверка элементов страницы оформления заказа")
    public PageWithHome checkBookingPage(String word) {
        bookingPage.shouldHave(text(word));
        return this;
    }

}
