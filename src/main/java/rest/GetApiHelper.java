package rest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Properties;

import static helpers.PropertiesLoader.readPropertyFile;


public class GetApiHelper {
    public static Response getResponseAsString(String apiUrl) {
        Properties browserProps = readPropertyFile("src/main/resources/api-config.properties");
        if (ResponseHandler.isNotNullOrEmpty(apiUrl))
            return RestAssured.
                    given().that()
                    .when()
                    .get(browserProps.getProperty("api-baseurl").concat(apiUrl))
                    .thenReturn();
        Assert.fail(ApiConstants.INVALID_EMPTY_URL_ERROR);
        return null;
    }

    public static Response getResponseAsString(String apiUrl, String parameter) {
        Properties browserProps = readPropertyFile("src/main/resources/api-config.properties");
        if (ResponseHandler.isNotNullOrEmpty(apiUrl))
            return RestAssured.given()
                    .that()
                    .when()
                    .get(browserProps.getProperty("api-baseurl").concat(apiUrl).concat(parameter))
                    .thenReturn();
        Assert.fail(ApiConstants.INVALID_EMPTY_URL_ERROR);
        return null;
    }
    public static Response getResponse(String apiUrl) {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl))
            return RestAssured.given().that().when().get(apiUrl).thenReturn();
        Assert.fail(ApiConstants.INVALID_EMPTY_URL_ERROR);
        return null;
    }

    public static Response getResponseByParams(String apiUrl, HashMap<String, String> params) {
        if (ResponseHandler.isNotNullOrEmpty(apiUrl))
            return RestAssured.given().that().params(params).when().get(apiUrl).thenReturn();
        Assert.fail(ApiConstants.INVALID_EMPTY_URL_ERROR);
        return null;
    }
}
