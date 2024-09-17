package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GithuProject {
    RequestSpecification requestSpec;
    ResponseSpecification respSpec;
    String sshKey="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";
    int sshKeyId;
    String accessToken="token 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";
    @BeforeClass
    public void setUp(){

        requestSpec  = new RequestSpecBuilder().
                setBaseUri("https://api.github.com/")
                .addHeader("Authorization", accessToken)
                .addHeader("Content-Type", "application/json").
                build();
        respSpec = new ResponseSpecBuilder().
                expectResponseTime(lessThan(4000L)).expectBody("key",equalTo(sshKey)).
                expectBody("title", equalTo("TestAPIKey")).
                build();
    }


    @Test(priority = 1)
    public void gitPostRequestTest(){
        Map<String, Object> reqbody = new HashMap<>();
        reqbody.put("title", "TestAPIKey");
        reqbody.put("key",sshKey);

        Response response = given().
                baseUri("https://api.github.com/user/keys").
                contentType(ContentType.JSON).
                body(reqbody).
                when().post();
        
       response.then().statusCode(201).spec(respSpec);
    }
    @Test(priority = 2)
    public  void gitGetRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId).when()
                .get("/{keyId}").then()
                .statusCode(200)
                .spec(respSpec);
        Reporter.log("Inside get request");
    }

    @Test(priority = 3)
    public void gitDeleteRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId).
                when().delete("/{keyId}").
                then().statusCode(204).body("id", equalTo("" + sshKeyId));
        Reporter.log("Inside delete request");
    }

}
