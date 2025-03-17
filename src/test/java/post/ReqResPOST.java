package post;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ReqResPOST {
    @Test
    protected void sendPostRequestUsingReqSpec(){
        RequestSpecification requestSpec1= RestAssured.given();
        File file=new File("src/test/resources/createUserOnReqRes.json");
        Response response = requestSpec1
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .baseUri("https://reqres.in")
                .basePath("api")
                .body(file)
                .when()
                .post("users")
                .then()
                .statusCode(201)
                .extract().response();
        Headers headers = response.headers();
        System.out.println("***************header***************** \n"+headers+"\n****************header****************");
        System.out.println("***************** Body: *****************\n"+response.body().prettyPrint()+"\n***************** Body: *****************\n");
        System.out.println("**********Status Code********************\n"+response.getStatusCode()+"\n**********Status Code********************\n");

    }
}
