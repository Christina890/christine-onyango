import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
public class User {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    @BeforeClass
    public void specs() {
        requestSpec = given().baseUri("https://petstore3.swagger.io/api/v3/user").contentType("application/json");
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        responseSpec = resBuilder.expectStatusCode(200).build();
    }

    private Response getUserResponse(){
        HashMap<String, Object> user=new LinkedHashMap<>();
        user.put("id", 10);
        user.put("username", "christine");
        user.put("firstName", "Christine");
        user.put("lastName", "Onyango");
        user.put("email", "tina@email.com");
        user.put("password", "12345");
        user.put("phone","12345");
        user.put("userStatus", 1);
        Response userResponse = given().spec(requestSpec).body(user).when().post();
        return userResponse;
    }
    @Test
    void createUser(){
        Response resp=getUserResponse();
        Assert.assertEquals(resp.getStatusCode(),200);
    }
    @Test
    void userLogin(){
        Response resp =getUserResponse();
        String username=resp.jsonPath().getString("username");
        String password=resp.jsonPath().getString("password");
        given().spec(requestSpec).formParam("username", username).formParam("password",password).basePath("/login").
                get().then().spec(responseSpec).log().all();
    }
    @Test
    void userLogout(){
        given().spec(requestSpec).basePath("/logout").get().then().spec(responseSpec).log().all();
    }
    @Test
    void getUser(){
        Response resp =getUserResponse();
        String username=resp.jsonPath().getString("username");
        given().spec(requestSpec).basePath(username).get().then().spec(responseSpec).log().all();
    }

    @Test
    void deleteUser() {
        Response resp = getUserResponse();
        String username = resp.jsonPath().getString("username");
        given().spec(requestSpec).basePath(username).get().then().spec(responseSpec).log().all();
//add update user
    }
}
