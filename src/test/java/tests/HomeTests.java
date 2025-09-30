package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

@Tag("regression")
public class HomeTests extends TestBase {

        HomePage steps = new HomePage();

        /* Чтобы передать данные в переменную email, нужно создать файл config.properties в корневой папке
        и в нем прописать данные в формате ключ=значение Например: email=vasya111@gmail.com */

        config.Properties prop = new config.Properties();
        private final String email = prop.getEmail();
        private final String phoneNumber = prop.getPhoneNumber();

        @Test
        @DisplayName("Проверка входа в аккаунт через электронную почту")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void loginEmailTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");

            steps.openEntry();
            step("Войти с помощью электронной почты", () -> {
                $(byTagAndText("button", "Войти по почте")).click();
            });
            step("Ввести электронную почту", () -> {
                $("[placeholder='Эл. почта']").setValue(email);
            });
            steps.entryInAccount();
        }

        @Test
        @DisplayName("Проверка входа в аккаунт через номер телефона")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void loginNumberTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");

            steps.openEntry();
            step("Ввести номер телефона", () -> {
                $("[placeholder='Телефон']").setValue(phoneNumber);
            });
            steps.entryInAccount();
        }

        @Test
        @DisplayName("Проверка отображения элементов главной страницы")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void homeTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");

            steps.checkTopHeader("Санкт-Петербург и ЛО");
            steps.checkTopHeader("Магазины");
            steps.checkTopHeader("Сервисные центры");
            steps.checkTopHeader("Бизнесу");
            steps.checkTopHeader("Блог");
            steps.checkTopHeader("Live ◎");
            steps.checkTopHeader("restore:u");
            steps.checkTopHeader("Доставка и оплата");
            steps.checkTopHeader("Где мой заказ?");

            steps.checkTopHeader("SMART-уход");
            steps.checkTopHeader("Привилегии");
            steps.checkTopHeader("New");
            steps.checkTopHeader("Sale");

            steps.checkTopHeader("Apple");
            steps.checkTopHeader("Смартфоны и гаджеты");
            steps.checkTopHeader("Компьютеры и ноутбуки");
            steps.checkTopHeader("ТВ, аудио и видео");
            steps.checkTopHeader("Для дома");
            steps.checkTopHeader("Красота и здоровье");
            steps.checkTopHeader("Развлечения");
            steps.checkTopHeader("Путешествия и спорт");
            steps.checkTopHeader("Аксессуары");

            steps.checkMainBanner();

            steps.checkCategories("Apple");
            steps.checkCategories("Смартфоны и гаджеты");
            steps.checkCategories("Компьютеры и ноутбуки");
            steps.checkCategories("ТВ, аудио и видео");
            steps.checkCategories("Для дома");
            steps.checkCategories("Красота и здоровье");
            steps.checkCategories("Развлечения");
            steps.checkCategories("Аксессуары");

            steps.checkCouldBeUseful("Вам может пригодиться");

            steps.checkPopularItems("Популярные товары");

            steps.checkSectionEcosystem("restore:");
            steps.checkSectionEcosystem("Больше, чем просто магазин устройств");
            steps.checkSectionEcosystem("Почему restore:?");
            steps.checkSectionEcosystem("Покупайте онлайн и в розничных магазинах restore:");
            steps.checkSectionEcosystem("Купить онлайн");
            steps.checkSectionEcosystem("Найти магазины");
            steps.checkSectionEcosystem("restore:care");
            steps.checkSectionEcosystem("restore:business");
            steps.checkSectionEcosystem("Найти магазины");

            steps.checkSectionBlog("Блог");
            steps.checkSectionBlog("Читай, смотри, действуй");
            steps.checkSectionBlog("Все статьи");
            steps.checkSectionBlog("Блог");
            steps.checkSectionBlog("Блог");
            steps.checkSectionBlog("Блог");

            steps.checkLowestFooter("Будьте в курсе последних новостей и акций");
            steps.checkLowestFooter("Ваш email");
            steps.checkLowestFooter("Отправить");
            steps.checkLowestFooter("О компании");
            steps.checkLowestFooter("Помощь");
            steps.checkLowestFooter("Каталог");
            steps.checkLowestFooter("iPhone");
        }

        @Test
        @DisplayName("Проверка работы чата")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void chatTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");
            Selenide.sleep(4500);

            step("Открыть чат", () -> {
                $("[name='flomni:toggler']").click();
                switchTo().frame("flomni:pager"); // Переход внтурь дерева чата
                $("[type='StartMessagingButton']").click();
            });
            step("Проверка отображения кнопки отправления сообщения", () -> {
                $("._7vjvu.ZOca1").shouldBe(visible);
            });
        }

        @Test
        @DisplayName("Проверка покупки ноутбука")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void e2eBuyMacBookTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");

            step("Выбрать категорию 'Компьютеры и ноутбуки'", () -> {
                $("[data-campaign-id='kompyutery-i-noutbuki']").click();
            });
            step("Выбрать ноутбук Apple", () -> {
                $(byTagAndText("div", "Ноутбуки")).closest("div").$(byText("Apple")).click();
            });
            step("Выбрать категорию Macbook Air", () -> {
                $(".fast-filter").$(byText("Macbook Air")).click();
            });
            steps.chooseProduct("MacBook Air");
            step("Добавить в избранное", () -> {
                $(".favorite__button").click();
            });
            step("Перейти в избранное", () -> {
                $(".header-icons__item").sibling(0).click();
            });
            steps.chooseProduct("MacBook Air");
            step("Добавить в корзину", () -> {
                $(byTagAndText("button", "Добавить в корзину")).click();
            });
            step("Закрыть предложенные товары", () -> {
                $(".modal-box__close").click();
            });
            step("Перейти в корзину", () -> {
                $(".header-icons__item").sibling(2).click();
            });
            step("Перейти к оформлению", () -> {
                $("#cartButton").click();
            });
            steps.checkBookingPage("Оформление заказа");
            steps.checkBookingPage("Телефон");
            steps.checkBookingPage("Имя");
            steps.checkBookingPage("E-mail");
            steps.checkBookingPage("Способ получения");
            steps.checkBookingPage("Способ оплаты");
            steps.checkBookingPage("При получении");
            steps.checkBookingPage("Перезвоните мне для подтверждения заказа");
            steps.checkBookingPage("Оформить заказ");

        }

        @Test
        @DisplayName("Проверка работы поиска")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void searchTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");

            step("Нажать на поле поиска", () -> {
                $(".search-line").click();
            });
            step("Ввести запрос в поиск", () -> {
                $("[placeholder=' Что вы ищете?']").setValue("dyson").pressEnter();
            });
            step("Проверка корректного отображения результата поиска предмета", () -> {
                $(".search-params__query").shouldHave(text("dyson"));
            });
            step("Проверка отображения предмета в каталоге", () -> {
                $(".catalog__products").shouldHave(text("dyson"));
            });
        }

        @Test
        @DisplayName("Проверка добавления товаров в сравнение")
        @Tag("smoke")
        @Owner("ChurinDmitiy")
        void compareTest() {
            steps.openPage();
            steps.chooseCity("Санкт-Петербург и ЛО");

            step("Выбрать категорию 'Apple'", () -> {
                $("[config.properties-campaign-id='apple']").click();
            });
            step("Выбрать категорию iPhone", () -> {
                $(".categories__item").click();
            });
            step("Выбрать первый iPhone", () -> {
                $(".product-card--hovered").$(".product-card__icon").click();
            });
            step("Выбрать второй iPhone", () -> {
                $(".product-card--hovered").sibling(0).$(".product-card__icon").click();
            });
            step("Перейти в сравнение товаров", () -> {
                $(".header-icons__item").sibling(1).click();
            });
            step("Проверка перехода в сравнение товаров", () -> {
                $(".compare__header").shouldHave(text("Сравнение товаров"));
            });
            step("Проверка отображения двух iPhone в сравнение товаров", () -> {
                $(".products__slide").shouldHave(text("IPhone"));
                $(".products__slide").sibling(0).shouldHave(text("IPhone"));
            });
        }
}

