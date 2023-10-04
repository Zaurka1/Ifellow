package ui.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import ui.pageObject.pageElems.TaskElems;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.switchTo;
import static java.time.zone.ZoneRulesProvider.refresh;

public class TaskSteps extends TaskElems {
    @Когда("^Открываем окно заведения бага и пишем название тест-кейса$")
    public static void setMainName() {
        Configuration.holdBrowserOpen = true;
        buttonCreateTask.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
            mainTheme.setValue("New Bug 01");
        }

    @И("^Заполняем поле Описание$")
    public static void setDescription() {
        switchTo().frame("mce_0_ifr");
        iframeText.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        iframeText.setValue("lololololo");
        switchTo().defaultContent();
    }

    @И("^Выставляем нужные версии для исправлений$")
    public static void setVersion() {
        fixInVersions.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
    }

    @И("^Заполняем поле Окружение$")
    public static void setEnv() {
        switchTo().frame("mce_6_ifr");
        iframeText.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        iframeText.setValue("hihihihihi");
        switchTo().defaultContent();
    }

    @И("^Выставляем затронутые версии$")
    public static void setAffectedVersions() {
        affectedVersions.scrollIntoView(true).click();
    }

    @И("^Назначаем себя в роли исполнителя$")
    public static void setRole() {
        buttonAppointMe.scrollIntoView(true).click();
    }

    @И("^Нажимаем кнопку Создать$")
    public static void createBug() {
        buttonCreate.scrollIntoView(true).click();
        refresh();
    }

    @Тогда("^Заходим в ранее заведенный баг, меняем статус и проверяем его, должен быть равен (.*)$")
    public static void setStatus(String expStatus) {
        linkMyBug.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        if (popup.is(Condition.visible)) {
            popup.click();
        }
        buttonMoreStatus.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        buttonStatusDone.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        if (statusCheck.text().equals("Готово")) {
            Assert.assertEquals(expStatus, statusCheck.text());
        } else {
            statusCheck.text();
        }
    }
}
