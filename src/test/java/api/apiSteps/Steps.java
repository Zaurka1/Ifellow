package api.apiSteps;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import static config.Configuration.getConfigurationValue;
import static io.restassured.RestAssured.given;

public class Steps {
        public static String charId;
        public static String charLocation;
        public static String charSpecies;
        public static String lastEpisode;
        public static String lastCharacterId;
        public static String lastCharLocation;
        public static String lastCharSpecies;

        public static void getFirstCharacter(String id) {
            String path = getConfigurationValue("URI_CHARACTERS") + id;
            Response responseMorty = given()
                    .filter(new AllureRestAssured())
                    .when()
                    .contentType(ContentType.JSON)
                    .request(Method.GET, path)
                    .then()
                    .extract()
                    .response();
            charId = new JSONObject(responseMorty.getBody().asString()).get("id").toString();
            charLocation = new JSONObject(responseMorty.getBody().asString()).getJSONObject("location").get("name").toString();
            charSpecies = new JSONObject(responseMorty.getBody().asString()).get("species").toString();
            Assert.assertEquals(200, responseMorty.getStatusCode());
        }

        public static void getLastEpisode() {
            String path = getConfigurationValue("URI_CHARACTERS") + charId;
            Response responseEpisode = given()
                    .filter(new AllureRestAssured())
                    .when()
                    .contentType(ContentType.JSON)
                    .request(Method.GET, path)
                    .then()
                    .extract()
                    .response();
            int episode = (new JSONObject(responseEpisode.getBody().asString()).getJSONArray("episode").length()-1);
            lastEpisode = String.valueOf(Integer.parseInt(new JSONObject(responseEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("\\D", "")));
            Assert.assertEquals(200, responseEpisode.getStatusCode());
        }

        public static void  getLastCharacterId() {
            String path = getConfigurationValue("URI_EPISODES") + lastEpisode;
            Response responseLastCharacterId = given()
                    .filter(new AllureRestAssured())
                    .when()
                    .contentType(ContentType.JSON)
                    .request(Method.GET, path)
                    .then().extract().response();
            int character = (new JSONObject(responseLastCharacterId.getBody().asString()).getJSONArray("characters").length()-1);
            lastCharacterId = String.valueOf(Integer.parseInt(new JSONObject(responseLastCharacterId.getBody().asString()).getJSONArray("characters").get(character).toString().replaceAll("\\D", "")));
            Assert.assertEquals(200, responseLastCharacterId.getStatusCode());
        }

        public static void getLastCharacterInfo() {
            String path = getConfigurationValue("URI_CHARACTERS") + lastCharacterId;
            Response responseLastCharacter = given()
                    .filter(new AllureRestAssured())
                    .when()
                    .contentType(ContentType.JSON)
                    .request(Method.GET, path)
                    .then()
                    .extract()
                    .response();
            charId = new JSONObject(responseLastCharacter.getBody().asString()).get("id").toString();
            lastCharLocation = new JSONObject(responseLastCharacter.getBody().asString()).getJSONObject("location").get("name").toString();
            lastCharSpecies = new JSONObject(responseLastCharacter.getBody().asString()).get("species").toString();
            Assert.assertEquals(200, responseLastCharacter.getStatusCode());
        }
    }
