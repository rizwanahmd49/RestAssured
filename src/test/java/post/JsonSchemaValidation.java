package post;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {


    @Test
    protected void requestSpecification() throws FileNotFoundException {

        InputStream inputStream = new FileInputStream("src/test/resources/createUserOnReqRes.json");
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setAccept("application/json")
                .setBaseUri("https://reqres.in")
                .setBasePath("api")
                .setContentType("application/json");
        RequestSpecification requestSpec = requestSpecBuilder.build();

        Response response = given()
                .spec(requestSpec)
                .body(inputStream)
                .when()
                .post("users");

        JsonPath jsonpath = response.jsonPath();
        Assert.assertEquals(response.getStatusCode(), 201);
        //Assert.assertEquals(jsonpath.get("Content-Type"),"application/json");
        System.out.println("Body\n" + jsonpath.prettyPrint());
        System.out.println(response.getHeader("Content-Type"));


    }

    @Test
    protected void validateSchema() {
        RequestSpecification builder = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .setBasePath("api").build();
        ValidatableResponse validatableResponse = given()
                .spec(builder)
                .when()
                .get("users/2")
                .then()
                .statusCode(200);//.assertThat().body(matchesJsonSchemaInClasspath("src/test/resources/schema/jsForcreateUserOnReqRes.json"));
        validatableResponse.log().all();

    }

    public static void main(String[] args) {
       
    }

}

