package helpers;

import static helpers.PropertiesLoader.readPropertyFile;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

import models.PostRewardsRequestModel;
import models.PostRewardsResponseModel;

import java.util.Properties;

public class ApiHelper {
    public static PostRewardsResponseModel createReward(PostRewardsRequestModel postRewardsRequestModel, int statusCode) {
        Properties browserProps = readPropertyFile("src/main/resources/api-config.properties");
        return given()
                .contentType(JSON)
                .body(postRewardsRequestModel)
                .when()
                .post(browserProps.getProperty("api-baseurl").concat("/api/loyalty/calculate-reward"))
                .then()
                .statusCode(statusCode)
                .extract()
                .as(PostRewardsResponseModel.class);
    }
}
