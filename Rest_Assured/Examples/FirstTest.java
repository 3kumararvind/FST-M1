package Examples;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FirstTest {
    //GET request
    @Test
    public void getRequestWithQueryParam(){
        Response response =
                given().
                    baseUri("https://petstore.swagger.io/v2/pet").
                    header("Content-Type", "application/json").
                        queryParam("status", "alive").
                        log().all().
                        when().
                        get("/findByStatus");

        System.out.println(response.getBody().asPrettyString());

        String petStatus = response.then().extract().path("[0]['status]");
        System.out.println("Pet Status= " + petStatus);

        Assert.assertEquals(petStatus, "alive");

    }
    @Test
    public void getRequestWithPathParam(){
        given().
                baseUri("https://petstore.swagger.io/v2/pet").
                header("Content-Type", "application/json").
                pathParam("petId", 772321).
                log().all().
                when().
                get("/{petId}").
                then().
                statusCode(200).
                body("name", equalTo("Riley")).
                log().all();
    }

    @Test
    public void addNewPet(){
        Map<String, Object> reqbody = new HashMap<>();
        reqbody.put("id", 77232);
        reqbody.put("name","Riley");
        reqbody.put("status", "alive");

        Response response = given().
                baseUri("https://petstore.swagger.io/v2/pet").
                contentType(ContentType.JSON).
                body(reqbody).
                when().post();

    }
}
