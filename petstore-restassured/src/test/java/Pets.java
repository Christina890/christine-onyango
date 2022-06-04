import static io.restassured.RestAssured.*;

import io.qameta.allure.Description;
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
import java.util.LinkedHashMap;
import java.util.Map;



public class Pets {

    String petId= utils.fetchConfigProperties("petId");
    String petName = utils.fetchConfigProperties("petName");
    String catergoryId=utils.fetchConfigProperties("catergoryId");
    String photourls=utils.fetchConfigProperties("photourls");
    String tagId= utils.fetchConfigProperties("photoId");
    String categoryName=utils.fetchConfigProperties("categoryName");
    String tagName=utils.fetchConfigProperties("photoName");
    String petStatus= utils.fetchConfigProperties("petStatus");

    private Response response;
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    public Pets() throws IOException {
    }

    @BeforeClass
    public void specs(){
        requestSpec=given().baseUri("https://petstore3.swagger.io/api/v3/pet").contentType("application/json");

        ResponseSpecBuilder resBuilder=new ResponseSpecBuilder();
        responseSpec= resBuilder.expectStatusCode(200).build();
    }

private Response addPet(){
    Map<String, Object> pet = new LinkedHashMap<>();
    pet.put("id", petId);
    pet.put("name", petName);
    Map<String, String> categoryMap = new LinkedHashMap<>();
    categoryMap.put("id", catergoryId);
    categoryMap.put("name", categoryName);
    pet.put("category",categoryMap);
    String[] photoList = {photourls};
    pet.put("photoUrls",photoList);
    Map<String, Object> tempTag= new LinkedHashMap<>();
    tempTag.put("id",tagId);
    tempTag.put("name",tagName);
    Map<Object, Object> tags = new LinkedHashMap<>();
    tags.put("tags",tempTag);
    pet.put("status",petStatus);
    Response resp = given().spec(requestSpec).when().body(pet).post();
    return resp;
}

    @Test
    @Description("Test Description: A user should be able to add pets successfully")
    void addPetTest(){
        addPet().then().spec(responseSpec);
    }

    @Test
    @Description("Test Description: A user should be able to fetch pets by status")
    void getPetByStatus(){
       given().spec(requestSpec).basePath("/findByStatus").queryParam("status", petStatus).when().get().then().spec(responseSpec).log().all();
    }

    @Test
    @Description(("Test Description: A user should be able to delete pets successfully"))
    void deletePet(){
        given().spec(requestSpec).basePath("/"+petId).when().delete().then().spec(responseSpec).log().all();
    }



}
