package Almosafer;

import enums.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.GetCurrencyResponseModel;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static rest.GetApiHelper.*;


public class GetCurrencyTest {

    @Test
    public void testResponseCode() {
        Response response = getResponseAsString(Endpoints.getCurrency.getValue());
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void testResponseBodyOne() {
        Response response = getResponseAsString(Endpoints.getCurrency.getValue());
        String responseBody = response.getBody().asString();
        Assert.assertTrue(!responseBody.isEmpty(), "Response body is empty!");

    }

    @Test
    public void testResponseBodyTwo() {
        Response response = getResponseAsString(Endpoints.getCurrency.getValue());
        String data = response.asString();
        System.out.println("data is " + data);
    }

    @Test
    public void testContentType() {
        Response response = getResponseAsString(Endpoints.getCurrency.getValue());
        response.then().assertThat().contentType(ContentType.JSON);

    }

    @Test
    public void testSpecificCurrencyPresent() {
        Response response = getResponseAsString(Endpoints.getCurrency.getValue());
        response.then().assertThat().body("equivalent.code", hasItem("QAR"));
    }

    @Test
    public void testSpecificCurrencyInformation() {
        Response response = getResponseAsString(Endpoints.getCurrency.getValue());
        String currencyCode = "SAR";
        given().when().response().then().statusCode(200).body("equivalent.code[0]", equalTo(currencyCode)).body("equivalent.name[0]", Matchers.notNullValue());
    }


    @Test
    public void testSpecificCurrencySymbol() {
        HashMap<String, String> params = new HashMap<>();
        params.put("symbol", "SAR");
        Response response = getResponseByParams(Endpoints.getCurrency.getValue(), params);
        GetCurrencyResponseModel[] getCurrencyResponseModel = response.then().extract().as(GetCurrencyResponseModel[].class);
        response.then().assertThat().body("symbol", hasItem(params.get("SAR")));

    }


}
