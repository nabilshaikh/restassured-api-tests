package api;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.CommonMethods;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class TC01_Lead {
	
	Dotenv dotenv = Dotenv.load();
	CommonMethods cm = new CommonMethods();
	
	@BeforeClass
	@Description("Verify the creation of a new lead")
    public void setup() {
        RestAssured.baseURI = dotenv.get("BASE_URI");
    }

//    private String readFileAsString(String file) throws IOException {
//        return new String(Files.readAllBytes(Paths.get(file)));
//    }

    @Test(enabled=true)
    @Step("Verify the creation of a new lead with mandatory and optional fields")
    public void testCreateNewLeadResourceByPassingMandatoryAndOptionalObjects() throws IOException {
        String bearerToken = dotenv.get("BEARER_TOKEN");
        
        // Read request body from file
        String requestBody = cm.readFileAsString("src/test/resources/leadRequestBody.json");
        
        Response response =
        given().
        	header("Authorization", "Bearer " + bearerToken).
        	header("Content-Type", "application/json").
        	body(requestBody).
        when().
        	post(dotenv.get("ENDPOINT_LEAD")).
        then().
        	statusCode(200). // assuming 201 is the expected status code for resource creation
        	body("id", notNullValue()). // verify that the 'id' attribute is present and not null
        	extract().
        	response();

//        Response response = given()
//            .header("Authorization", "Bearer " + bearerToken)
//            .header("Content-Type", "application/json")
//            .body(requestBody)
//            .when()
//            .post("/v3/connect/lead/")
//            .then()
//            .statusCode(200) // assuming 201 is the expected status code for resource creation
//            .body("id", notNullValue()) // verify that the 'id' attribute is present and not null
//            .extract()
//            .response();

        // Assertions
        String id = response.path("id");
        assertTrue(id.startsWith("led_"), "Expected 'id' to start with 'led_', but got: " + id);
        System.out.println("Created Resource ID: " + id);
        System.out.println("Resp is: " + response.asPrettyString());
    }
    
    
    @Test(enabled=true)
    @Step("Verify the lead resource should not be created if the response body is blank")
    public void testCreateNewLeadResourceByPassingBlankResponse() throws IOException {
        String bearerToken = dotenv.get("BEARER_TOKEN");
        
        // Read request body from file
        String requestBody = "{}";
        
        Response response =
        given().
        	header("Authorization", "Bearer " + bearerToken).
        	header("Content-Type", "application/json").
        	body(requestBody).
        when().
        	post(dotenv.get("ENDPOINT_LEAD")).
        then().
        	statusCode(400).
        	extract().
        	response();

        String description = response.jsonPath().getString("errors[0].description");
        assertEquals(description, "Body cannot be empty or null", "Expected description does not match");
    }
	
	@Test(enabled=true)
	@Step("Verify the lead resource should not be created if the response body is incomplete")
    public void testCreateNewLeadResourceByPassingIncompleteObjects() throws IOException {
        String bearerToken = dotenv.get("BEARER_TOKEN");
        
        // Read request body from file
        String requestBody = cm.readFileAsString("src/test/resources/req.json");
        
        Response response =
        given().
        	header("Authorization", "Bearer " + bearerToken).
        	header("Content-Type", "application/json").
        	body(requestBody).
        when().
        	post(dotenv.get("ENDPOINT_LEAD")).
        then().
        	extract().
        	response();
        System.out.println("Resp is: " + response.asPrettyString());
        assertEquals(response.statusCode(), 400);
    }

}
