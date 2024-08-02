package dto;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class Token {

    /**
     *This method getToken() sends a POST request to an endpoint to obtain an authentication token
     *It constructs a JSON request body with a username and password
     * It then sends this request using RestAssured library, checks if the response status code is 200,
     * parses the response body JSON to extract the authentication token, prints it, and returns the token.
     */
    public static String getToken(){

        // Get Token
        String requestBody = "{\"username\": \"Charlie\", \"password\": \"123456\"}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("https://base URL/Token");

        assertEquals(response.getStatusCode(), 200, "Unexpected status code");

        // Parse JSON response using Gson
        JsonObject jsonResponse = new Gson().fromJson(response.getBody().asString(), JsonObject.class);

        String token = jsonResponse.get("data").getAsString();
        System.out.println("Token: " + token);

        return token;
    }
}
