import static io.restassured.RestAssured.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
public class User {

    String username = utils.fetchConfigProperties("username");
    String userId = utils.fetchConfigProperties("userId");
    String firstName=utils.fetchConfigProperties("firstName");
    String lastName=utils.fetchConfigProperties("lastName");
    String email= utils.fetchConfigProperties("email");
    String password=utils.fetchConfigProperties("password");
    String phone = utils.fetchConfigProperties("phone");
    String userBaseUrl = utils.fetchConfigProperties("userBaseUrl");

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    public User() throws IOException {
    }

    @BeforeClass
    public void specs() {
        requestSpec = given().baseUri(userBaseUrl).contentType("application/json");
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        responseSpec = resBuilder.expectStatusCode(200).build();
    }

    private Response getUserResponse(){
        HashMap<String, Object> user=new LinkedHashMap<>();
        user.put("id", userId);
        user.put("username", username);
        user.put("firstName", firstName);
        user.put("lastName", lastName);
        user.put("email", email);
        user.put("password", password);
        user.put("phone",phone);
        user.put("userStatus", 1);
        Response userResponse = given().spec(requestSpec).body(user).when().post();
        return userResponse;
    }
    @Test
    void createUser(){
    getUserResponse().then().spec(responseSpec);
    }
    @Test
    void userLogin(){
        given().spec(requestSpec).formParam("username", username).formParam("password",password).basePath("/login").
                get().then().spec(responseSpec).log().all();
    }
    @Test
    void userLogout(){
        given().spec(requestSpec).basePath("/logout").get().then().spec(responseSpec).log().all();
    }

    @Test
    void getUser(){

        given().spec(requestSpec).basePath("/"+username).get().then().spec(responseSpec).log().all();
    }

    @Test
    void deleteUser() {
        given().spec(requestSpec).basePath("/christine").get().then().spec(responseSpec).log().all();
    }
}
