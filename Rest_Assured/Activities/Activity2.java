package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    final static String Root_URI = "https://petstore.swagger.io/v2/user";
    @Test(priority = 1)
    public void addUser() throws IOException {
        FileInputStream inputJSON = new FileInputStream("src/test/java/Activities/user.json");
        String reqBody = new String(inputJSON.readAllBytes());

        Response response = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
                .when().post(Root_URI);

        inputJSON.close();
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("23132"));

    }
    @Test(priority = 2)
    public void getDetails(){
        File outputJSON = new File("src/test/java/activities/userGETResponse.json");
        Response response =
                given()
                .contentType(ContentType.JSON)
                .pathParam("username", "AKUMAR")
                .get(Root_URI + "/{username}");
        String resBody = response.getBody().asPrettyString();
        try {
            outputJSON.createNewFile();
            FileWriter writer = new FileWriter(outputJSON.getPath());
            writer.write(resBody);
            writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        response.then().body("id", equalTo(23132));
        response.then().body("username", equalTo("AKUMAR"));
        response.then().body("firstName", equalTo("Arvind"));
        response.then().body("lastName", equalTo("Kumar"));
        response.then().body("email", equalTo("akumar@gmail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9876543210"));
    }

    @Test(priority = 3)
    public void deleteUser() throws IOException {
        Response response =
                given().contentType(ContentType.JSON)
                        .pathParam("username", "AKUMAR")
                        .when().delete(Root_URI + "/{username}");

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("AKUMAR"));
    }
}
