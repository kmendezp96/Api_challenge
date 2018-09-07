package helpers;

import io.restassured.response.Response;

import static net.serenitybdd.rest.SerenityRest.given;

public class ResponseHelper {
    private static Response response;

    public ResponseHelper(String url) {
        response = given().contentType("application/json")
                .when().get(url);
    }

    public static Response getResponse() {
        return response;
    }
}
