package ui.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import ui.pageObject.pageElems.VersionPageElems;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class VersionPageSteps extends VersionPageElems {
    @Тогда("^Проверяем версию, должна быть Version 2.0$")
    public static void checkVersion() {
        assertEquals("Version 2.0", version.shouldBe(Condition.visible, Duration.ofSeconds(60)).text());
    }

    @И("^Проверяем статус задачи TestSelenium, должен быть (.*)$")
    public static void checkStatus(String expStatus) {
        task.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        assertEquals(expStatus, status.text());
    }
}
