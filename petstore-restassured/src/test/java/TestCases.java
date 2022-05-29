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



public class TestCases {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void specs(){
        requestSpec=given().baseUri("https://petstore3.swagger.io/api/v3/pet").contentType("application/json");

        ResponseSpecBuilder resBuilder=new ResponseSpecBuilder();
        responseSpec= resBuilder.expectStatusCode(200).build();
    }

    @Test
    void addPet(){
        Map<String, Object> pet = new LinkedHashMap<>();
        pet.put("id", "23");
        pet.put("name", "Scooby");
        Map<String, String> categoryMap = new LinkedHashMap<>();
        categoryMap.put("id", "2");
        categoryMap.put("name", "dogs");
        pet.put("category",categoryMap);
        String[] photolist = {"url"};
        pet.put("photoUrls",photolist);
        pet.put("status","available");
        //Map<String, String> tags = new LinkedHashMap<>();
        //tags.put("id","0");
        //tags.put("name","doggie");
        //pet.put("tags",tags);
        pet.put("status","available");
        given().spec(requestSpec).when().body(pet).post().then().spec(responseSpec);


    }
    @Test
    void getPet(){
        Response response = given().spec(requestSpec).basePath("/findByStatus").queryParam("status", "available").when().get();
        Assert.assertEquals(response.getStatusCode(),200);

    }

}
