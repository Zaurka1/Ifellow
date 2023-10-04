package api.stepsDefinition;

import api.apiSteps.CreationSteps;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.io.IOException;

public class ReqresDefinition extends CreationSteps {
    @Дано("^Создаем данные для отправки$")
    public static void createAllData() throws IOException {
        createMainData();
    }

    @Когда("^Делаем запрос на создание юзера, меняем данные$")
    public static void doAllResponse() {
        doCreationResponse();
    }

    @Тогда("^Сверяем пришедший ответ с ожидаемым$")
    public static void assertAll() {
        assertCreationResponse();
    }
}