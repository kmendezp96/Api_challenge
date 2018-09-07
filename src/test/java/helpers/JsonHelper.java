package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;

import static scala.Predef.StringFormat;

public class JsonHelper {

    public static JsonObject getJsonObjectFromResponse(Response response) {
        String jsonString = response.then().extract().response().body().print();
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static JsonArray getJsonObjectListFromResponse(Response response) {
        String jsonString = response.then().extract().response().body().print();
        return new JsonParser().parse(jsonString).getAsJsonArray();
    }

    public static String getInstancesJson() {
        String jsonString = String.format("\"host\":\"%s\",\"port\":%s,\"storeNames\":[%s]",
                PropertiesHelper.getHost(),
                PropertiesHelper.getPort(),
                PropertiesHelper.getStoreNames());
        return jsonString;
    }
}
