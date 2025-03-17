package get;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleBookAPI {


    @Test
    private void validateComplexJsonResponse(){
        String jsonResponse="{\n" +
                "    \"page\": 1,\n" +
                "    \"per_page\": 6,\n" +
                "    \"total\": 12,\n" +
                "    \"total_pages\": 2,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"email\": \"george.bluth@reqres.in\",\n" +
                "            \"first_name\": \"George\",\n" +
                "            \"last_name\": \"Bluth\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/1-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"email\": \"janet.weaver@reqres.in\",\n" +
                "            \"first_name\": \"Janet\",\n" +
                "            \"last_name\": \"Weaver\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"email\": \"emma.wong@reqres.in\",\n" +
                "            \"first_name\": \"Emma\",\n" +
                "            \"last_name\": \"Wong\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/3-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"email\": \"eve.holt@reqres.in\",\n" +
                "            \"first_name\": \"Eve\",\n" +
                "            \"last_name\": \"Holt\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/4-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"email\": \"charles.morris@reqres.in\",\n" +
                "            \"first_name\": \"Charles\",\n" +
                "            \"last_name\": \"Morris\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/5-image.jpg\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 6,\n" +
                "            \"email\": \"tracey.ramos@reqres.in\",\n" +
                "            \"first_name\": \"Tracey\",\n" +
                "            \"last_name\": \"Ramos\",\n" +
                "            \"avatar\": \"https://reqres.in/img/faces/6-image.jpg\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
                "        \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
                "    }\n" +
                "}";


        JsonPath jsonPath=new JsonPath(jsonResponse);
        int name = jsonPath.getInt("per_page");
        Object totalPages = jsonPath.get("total_pages");
        String text = jsonPath.getString("support.text");
        System.out.println("Name: "+name);
        System.out.println("Total Pages: "+totalPages);
        System.out.println("$.support.text: "+text);


    }

    @Test
    private void readComplexResponse(){
        RestAssured.baseURI="https://reqres.in";
        Response response = given()
                .basePath("/api/users")
                .queryParam("page", "2")
                .when()
                .get();
        System.out.println("Status Code: "+response.getStatusCode());

        JsonPath jsonpath = response.jsonPath();
        String url=jsonpath.getString("support.url");
        System.out.println(url);
        Assert.assertEquals(jsonpath.getString("data[2].last_name"), "Funke", "Last name is not as expected!");
    }
}
