package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private final SelenideElement
            cookieBtn = $(".cookie-agreement").$(byTagAndText("button", "Хорошо")), // Кнопка закрытия окна с куками
            header = $(".header"), // Верхний хедер
            mainBanner = $(".section-slider"), // Основной баннер
            categories = $(".section-categories"), // Категории
            couldBeUseful = $("#gf-wrapper-recs-gf-hp-1"), // Вам может пригодиться
            popularItems = $("#gf-wrapper-recs-gf-hp-2"), // Популярные товары
            sectionEcosystem = $(".section-ecosystem"), // Больше, чем просто магазин устройств
            sectionBlog = $(".section-products"), // Блог. Читай, смотри, действуй
            lowestFooter = $(".prerender-footer"), // Нижняя секция, все после блога
            product = $(".product-card--hovered"), // Продукт
            bookingPage = $(".popmechanic-desktop"), // Страница оформления заказа
            location = $(".location"); // Кнопка выбора локации



    @Step("Открыть главную страницу")
    public void openPage() {
        open("");
        Selenide.sleep(3000);
        if (cookieBtn.isDisplayed()) {
            cookieBtn.click();
        }
    }

    @Step("Выбор города")
    public void chooseCity(String city) {
        location.click();
        $(byText(city)).click();
    }

    @Step("Открыть вход в аккаунт")
    public void openEntry() {
        $(".header-icons__item").click(); // Навестись на иконку входа
        $(".header-dropdown-lk__btn").click(); // Открыть форму входа
    }

    @Step("Войти в аккаунт")
    public void entryInAccount() {
        $(".form-auth__button").$(byTagAndText("button", "Войти")).shouldBe(visible); // По сути тест не полноценный, т.к Проверки входа нет,
    }                                                                                                         // я просто решил завершить тест на этом,

    @Step("Проверка элементов верхнего блока")
    public void checkTopHeader(String element) {
        header.shouldHave(text(element));
    }

    @Step("Проверка отображения главного баннера")
    public void checkMainBanner() {
        mainBanner.shouldBe(visible);
    }

    @Step("Проверка отображения категорий товаров")
    public void checkCategories(String element) {
        categories.shouldHave(text(element));
    }

    @Step("Проверка отображения блока 'Вам может пригодиться'")
    public void checkCouldBeUseful(String element) {
        couldBeUseful.shouldHave(text(element));
    }

    @Step("Проверка отображения блока популярных товаров")
    public void checkPopularItems(String element) {
        popularItems.shouldHave(text(element));
    }

    @Step("Проверка отображения блока экосистемы")
    public void checkSectionEcosystem(String element) {
        sectionEcosystem.shouldHave(text(element));
    }

    @Step("Проверка отображения блока блога")
    public void checkSectionBlog(String element) {
        sectionBlog.shouldHave(text(element));
    }

    @Step("Проверка отображения нижнего футера")
    public void checkLowestFooter(String element) {
        lowestFooter.shouldHave(text(element));
    }

    @Step("Выбрать продукт")
    public void chooseProduct(String word) {
        product.click();
    }

    @Step("Проверка элементов страницы оформления заказа")
    public void checkBookingPage(String word) {
        bookingPage.shouldHave(text(word));
    }

}
