package api;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static api.stepsDefinition.ReqresDefinition.*;
import static api.stepsDefinition.StepDefinition.*;

public class ApiTest {

    @Test
    @DisplayName("Меняем данные в JSON")
    public void changeDataTest() throws IOException {
        createAllData();
        doAllResponse();
        assertAll();
    }

    @Test
    @DisplayName("Тестируем api Рика(огурчика) и Морти")
    public void RickAndMortyTest() {
        getFirstChar();
        getLastEp();
        getLastCharId();
        getLastCharInfo();
        checkCharactersRaces(); // Расы совпадают
        checkCharactersLocations(); // Живут в разных местах
    }

}