package ui.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import ui.pageObject.pageElems.LoginElems;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class AuthSteps extends LoginElems {

    @Дано("^Открываем страницу (.*)$")
    public static void openUrl(String url) {
        open(url);
    }

    @Когда("^Заполняем все данные: логин - (.*), пароль - (.*), попадаем в личный кабинет$")
    public static void authorization(String login, String pass) {
        inputLogin.shouldBe(Condition.visible, Duration.ofSeconds(60))
                .click();
        inputLogin.setValue(login);
        inputPassword.shouldBe(Condition.visible, Duration.ofSeconds(60))
                .click();
        inputPassword.setValue(pass);
        inputPassword.pressEnter();
    }

    @Тогда("^Проверяем наше местоположение внутри лк с login = (.*)$")
    public static void check_auth(String login) {
        Assert.assertEquals("Пользовательский профиль для " + login,
                accessAuth.getAttribute("title"));
    }
}
