package ui.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import ui.pageObject.pageElems.MainPageElems;

import java.time.Duration;

public class MainPageSteps extends MainPageElems {

    @И("^Переходим в раздел Проекты$")
    public static void goToTasks() {
        buttonProjects.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        dropdownMenu.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        buttonTestProject.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
        buttonTasks.shouldBe(Condition.visible, Duration.ofSeconds(60)).click();
    }

    @Тогда("^Проверяем количество заведенных задач, должно быть больше 0$")
    public static void checkNumberOfTasks() {
        int val = Integer.parseInt(tasksNumber.shouldBe(Condition.visible, Duration.ofSeconds(60)).getText().substring(0, tasksNumber.getText().indexOf(" ")));
        Assert.assertTrue(val > 0);
    }

}
