package Test;

import api.dto.PostReturn;
import api.dto.PutDeliveryInfo;
import api.dto.PutRetailerOrder;
import core.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ui.userarea.OrderDetail;
import ui.userarea.ReturnOrder;
import ui.userarea.UserLogin;
import utils.Logger;

import static dto.RandomNumber.generateRandomNumber;
import static dto.Token.getToken;
import static io.restassured.RestAssured.given;

public class TestRunner extends BaseTest {

    @BeforeSuite
    public void setUp() throws InterruptedException {
        randomNumber  = generateRandomNumber();
        putRetailerOrder();
        postReturn();
        putDeliveryInfo();
        Thread.sleep(15000);
        Logger.generalLog(randomNumber + " " + returnId);
    }

    static String randomNumber;
    static String returnId;

    /**
     *This method sends a PUT request to a specific
     *endpoint with some predefined headers and content type
     *It includes an authorization token obtained from the getToken() method
     *and sends a JSON body containing data of an object of type PutRetailerOrder.
     *The endpoint URL is composed of a base URL and a random number appended to it.
     */
    public static void  putRetailerOrder () {
        Logger.GeneralLog("Creating of PutRetailerOrder start");

        given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(new PutRetailerOrder())
                .put("https://base URL/RetailerOrders/" + randomNumber).
                then().log().body().assertThat().statusCode(200);

        Logger.GeneralLog("Successful Creation" + randomNumber);

    }

    /**
     *This method performs an HTTP POST request to a specified endpoint URL with some data.
     *It sets the authorization header using a token obtained from getToken(),
     *specifies JSON as the content type, and sends a POST request with a payload of an object of type PostReturn.
     *It then extracts the returned ID from the response JSON and stores it in the returnId variable.
     */
    public static void postReturn () {
        Logger.GeneralLog("PostReturn start");

        Response responseReturn =
                given()
                        .header("Authorization", "Bearer " + getToken())
                        .contentType(ContentType.JSON)
                        .body(new PostReturn())
                        .when()
                        .post("https://base URL/RetailerOrders/" + randomNumber + "/return");
        returnId  =  responseReturn.jsonPath().getString("data.returnId");

        Logger.GeneralLog("PostReturn Successful Created" + returnId);


    }

    /**
     *This method performs an HTTP PUT request to a specific endpoint.
     *It sets the authorization header with a bearer token retrieved by getToken(), specifies the content type as JSON,
     *and includes a request body generated by creating a new instance of PutDeliveryInfo class.
     *Finally, it sends the request to the specified URL formed by concatenating the base endpoint, returnId, and "/DeliveryInformation".
     */
    public static void putDeliveryInfo(){
        Logger.GeneralLog("PutDeliveryInfo start");

        given()
                .header("Authorization", "Bearer " + getToken())
                .contentType(ContentType.JSON)
                .body(new PutDeliveryInfo())
                .when()
                .put("https://base URL/Returns/" + returnId + "/DeliveryInformation")
                .then().log().body().assertThat().statusCode(200);

        Logger.GeneralLog("PutDeliveryInfo Successful" + returnId);
    }

    @Test
    public void orderCreationAndValidation(){
        UserLogin.open();
        UserLogin.login("CharlieHarper@email.com", "123456");
        UserLogin.verifyUserFullName("Welcome, Charlie Harper", "User info text does not match expected.");
        ReturnOrder.verifyReturnOrderPage("Return Orders", "Wrong Page");
        ReturnOrder.searchOrder(randomNumber);
        ReturnOrder.goToOrderDetailsPage();
        OrderDetail.verifyOrderDetailPage("Return shipping method:", "Not the same page");
        OrderDetail.downloadLabel();
        UserLogin.userLogout();
        UserLogin.verifyUserLogout("Please, enter your login details", "Not logged out");
    }


}
