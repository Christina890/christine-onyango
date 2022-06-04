import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class Store {

    String orderPetId= utils.fetchConfigProperties("orderPetId");
    String orderId = utils.fetchConfigProperties("orderId");
    String orderStatus=utils.fetchConfigProperties("orderStatus");
    String orderQuantity=utils.fetchConfigProperties("orderQuantity");
    String orderShipDate= utils.fetchConfigProperties("orderShipDate");
    String orderCompletionStatus=utils.fetchConfigProperties("orderCompletionStatus");
    String storeBaseUrl = utils.fetchConfigProperties("storeBaseUrl");

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    public Store() throws IOException {
    }

    @BeforeClass
        public void specs(){
            requestSpec=given().baseUri(storeBaseUrl).contentType("application/json");
            ResponseSpecBuilder resBuilder=new ResponseSpecBuilder();
            responseSpec= resBuilder.expectStatusCode(200).build();
        }
        @BeforeMethod
        public Response placeOrderResponse(){
            HashMap<String, Object> petOrder=new LinkedHashMap<>();
            petOrder.put("id",orderId);
            petOrder.put("petID",orderPetId);
            petOrder.put("status",orderStatus);
            petOrder.put("quantity",orderQuantity);
            petOrder.put("shipDate",orderShipDate);
            petOrder.put("complete",orderCompletionStatus);
            Response resp = given().spec(requestSpec).basePath("/order").when().body(petOrder).post();
            return resp;
        }
        @Test
        void getStoreInventory(){
            given().spec(requestSpec).basePath("/inventory").when().get().then().spec(responseSpec).log().all();
        }
        @Test
        void placeOrder(){
        Response orderResponse = placeOrderResponse();
        Assert.assertEquals(orderResponse.getStatusCode(), 200);

        }
        @Test
        void findOrder(){
            given().spec(requestSpec).basePath("/order/10").when().get().then().spec(responseSpec).log().all();
        }
        @Test
        void deleteOrder(){
            given().spec(requestSpec).basePath("/order/10").when().delete().then().spec(responseSpec).log().all();
        }

        @AfterTest
        void clearOrder(){
            given().spec(requestSpec).basePath("/order/10").when().delete();
        }
    }


