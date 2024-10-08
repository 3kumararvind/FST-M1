package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //set Headers
    Map<String, String> headers = new HashMap<>();

    //Create the contract
    @Pact(consumer = "UserConsumer", provider ="UserProvider" )
    public RequestResponsePact createPact(PactDslWithProvider builder){
        headers.put("Content-Type", "application/json");

        //RequestAndResponse
        DslPart reqAndResBody = new PactDslJsonBody()
                .numberType("id", 3435)
                .stringType("firstName", "Arvind")
                .stringType("lastName", "Kumar")
                .stringType("email", "testibm16@gmail.com");
        //Interactions
        return builder.given("POST Request").
                uponReceiving("a request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqAndResBody)
                .willRespondWith()
                .status(201)
                .body(reqAndResBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName ="UserProvider" ,port="8282")
    public void postRequestTest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 2201);
        reqBody.put("firstName", "Mohan");
        reqBody.put("lastName", "Singh");
        reqBody.put("email","abc@BeforeAll");

        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).log().all().
                when().post("/api/users").
                then().statusCode(201).body("firstName", equalTo("Arvind")).log().all();
    }

}
