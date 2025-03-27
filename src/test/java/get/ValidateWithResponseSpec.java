package get;

import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class ValidateWithResponseSpec {

    /**
     * Scenario: Validate User Details
     * We want to:
     * Verify the status code is .
     * Check the header  Content-Type is application/json
     * Assert that the user's first_name is "Janet"
     * Verify the user ID is 2
     */
    @Test
    private void validateUserDetails(){

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectHeader("Content-Type", "application/json; charset=utf-8")
                .expectBody("data.name", equalToObject("fuchsia rose"))
                .expectBody("data.id", equalTo(2))
                .expectBody("data.year", equalTo(2001))
                .expectBody("support.url", equalTo("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral"))
                .build();

        given()
                .baseUri("https://reqres.in/")
                .basePath("api")
                .when()
                .get("user/2")
                .then()
                .log()
                .all()
                .spec(responseSpec);

        
    }
}
