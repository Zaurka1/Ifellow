package api.stepsDefinition;

import api.apiSteps.Steps;
import config.Configuration;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class StepDefinition extends Steps {
   @Дано("^Вытаскиваем информацию по первому персонажу и проверяем статус код$")
   public static void getFirstChar() {getFirstCharacter(Configuration.getConfigurationValue("firstCharacterId"));}

   @И("^Ищем последний эпизод и проверяем статус код$")
   public static void getLastEp() {
       getLastEpisode();
   }

   @И("^Ищем id последнего персонажа и проверяем статус код$")
   public static void getLastCharId() {getLastCharacterId();}

   @И("^Вытаскиваем информацию по последнему персонажу и проверяем статус код$")
   public static void getLastCharInfo() {
        getLastCharacterInfo();
    }

   @Тогда("^Сравниваем расы$")
   public static void checkCharactersRaces() {
       assertEquals(charSpecies, lastCharSpecies);
   }

   @Тогда("^Сравниваем локацию")
   public static void checkCharactersLocations() {
       assertNotEquals(charLocation, lastCharLocation);
   }
}

