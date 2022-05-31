import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class Store {
        RequestSpecification requestSpec;
        ResponseSpecification responseSpec;
        @BeforeClass
        public void specs(){
            requestSpec=given().baseUri("https://petstore3.swagger.io/api/v3/store").contentType("application/json");
            ResponseSpecBuilder resBuilder=new ResponseSpecBuilder();
            responseSpec= resBuilder.expectStatusCode(200).build();
        }
        @BeforeMethod
        public Response getOrderResponse(){
        HashMap<String, Object> petOrder=new LinkedHashMap<>();
        petOrder.put("id",10);
        petOrder.put("petID",198772);
        petOrder.put("status","approved");
        petOrder.put("quantity",3);
        petOrder.put("shipDate","2022-05-29T09:16:26.118Z");
        petOrder.put("complete",true);
        Response resp = given().spec(requestSpec).basePath("/order").when().body(petOrder).post();
        return resp;
    }

        @Test
        void getStoreInventory(){
            given().spec(requestSpec).basePath("/inventory").when().get().then().spec(responseSpec).log().all();
        }

        @Test
        void placeOrder(){
           Response makeOrder=getOrderResponse();
           Assert.assertEquals(makeOrder.getStatusCode(), 200);
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


