import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    }


