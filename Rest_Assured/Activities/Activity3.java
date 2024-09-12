package Activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity3 {
    RequestSpecification reqSpec;
    ResponseSpecification respSpec;

    @BeforeClass
    public void setUp(){
        reqSpec =  new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .build();
        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status", equalTo("alive"))
                .build();
    }
        @DataProvider
        public Object[][] petInfoProvider() {
            Object[][] data = new Object[][] {
                    { 77232, "Riley", "alive" },
                    { 77233, "Hansel", "alive" }
            };
            return data;
        }
        @Test(priority = 1)
    public void addPet(){
            String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
            Response response = given().spec((RequestSpecification) reqSpec)
                    .body(reqBody)
                    .when().post();
            reqBody = "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";
            response = given().spec((RequestSpecification) reqSpec)
                    .body(reqBody)
                    .when().post();

            response.then().spec(respSpec);
        }

    @Test(dataProvider = "petInfoProvider", priority=2)
    public void getPets(int id, String name, String status) {
        Response response = given().spec((RequestSpecification) reqSpec)
                .pathParam("petId", id)
                .when().get("/{petId}");

        System.out.println(response.asPrettyString());

        response.then()
                .spec(respSpec)
                .body("name", equalTo(name));
    }

    // Test case using a DataProvider
    @Test(dataProvider = "petInfoProvider", priority=3)
    public void deletePets(int id, String name, String status) {
        Response response = given().spec((RequestSpecification) reqSpec)
                .pathParam("petId", id)
                .when().delete("/{petId}");
        response.then().body("code", equalTo(200));
    }

}
