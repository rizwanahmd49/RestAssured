package get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

public class Reqres {
    RequestSpecification requestSpec;

    @BeforeTest
    void tearUp() {
        requestSpec = RestAssured.given();
        //set BaseURI
        requestSpec.baseUri("https://reqres.in");
        // Set basePath
        requestSpec.basePath("/api");
        //set Headers
        requestSpec.header("Accept", "application/json");
    }

    @Test
    private void getSingleUserDetails() {

        Response response = requestSpec.get("/users/2");
        String body = response.getBody().toString();
        System.out.println(body);


        /// Retrieve data from response using JsonPath Class
        JsonPath jsonPath = response.jsonPath();
        String email = jsonPath.get("data.email");
        String lastName = jsonPath.getString("data.last_name");
        String name = jsonPath.get("data.first_name");
        System.out.println("***********Value retrieved from JsonPath Class************\nEmail: " + email + "\nName: " + name + "\nLast Name: " + lastName + "\n*****************************************\n\n");


        // Print response
        System.out.println("Response Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Test
    protected static void getUserList() {
        RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api")
                .header("Accept", "application/json")
                .when()
                .get("users?page=2")
                .then()
                .statusCode(200)
                .log()
                .all();

    }

    @Test
    protected static void storeResponseToFile() {
        String res = RestAssured.given()
                .basePath("/api")
                .baseUri("http://reqres.in")
                .when()
                .get("/users?page=2")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asPrettyString();

        try {
            FileWriter fileWriter = new FileWriter("target/responses/userList.json");
            fileWriter.write(res);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void validateJsonSchema(){


    }




}
