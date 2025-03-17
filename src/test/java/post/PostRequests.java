package post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class PostRequests {

    @Test
    protected void getToken(){
        String jsonBody="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        Response response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .post("/auth");
        System.out.println(response.asPrettyString());

        ValidatableResponse validatableResponse=response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("token", Matchers.notNullValue());
    }

    @Test
    protected void validateAuthToken() throws IOException {
        byte[] file = Files.readAllBytes(Paths.get("src/test/resources/createToken.json"));
        String filePayload=new String(file);
        System.out.println("Payload from File: \n"+filePayload);
        String jsonBody="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        Response response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .body(filePayload)
                .header("Content-Type","application/json")
                .post("/auth")
                        .then().log().all()
                        .extract().response();


        System.out.println(response.asPrettyString());


    }

    public static void main(String[] args) {
        File file1=new File("src/test/resources/createToken.json");
        Response response = RestAssured.given()
                .body(file1)
                .baseUri("https://restful-booker.herokuapp.com")
                .header("Content-Type", "application/json")
                .post("/auth")
                .then()
                .statusCode(200)
                .log().cookies()
                .extract().response();

        System.out.println(response.asPrettyString());

        Object token = response.jsonPath().get("token");
        String authToken = response.jsonPath().getString("token");
        System.out.println("token with get() => "+token+"\ntoken with getString() => "+authToken);
    }




}
