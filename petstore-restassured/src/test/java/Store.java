import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        @Test
        void getStoreInventory(){
            given().spec(requestSpec).basePath("/inventory").when().get().then().spec(responseSpec).log().all();
        }
        @Test
        void placeOrder(){
            HashMap<String, Object> petOrder=new LinkedHashMap<>();
            petOrder.put("id",10);
            petOrder.put("petID",198772);
            petOrder.put("shipDate","approved");
            petOrder.put("quantity",3);
            petOrder.put("status","2022-05-29T09:16:26.118Z");
            petOrder.put("complete",true);
            given().spec(requestSpec).basePath("/order").when().body(petOrder).post().then().spec(responseSpec).log().all();
        }
        @Test
        void findOrder(){
            given().spec(requestSpec).basePath("/order/10").when().get().then().spec(responseSpec).log().all();
        }
    }


