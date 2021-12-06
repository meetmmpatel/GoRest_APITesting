package com.jsonplaceholder.api.stepDefinition;


import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.http.ContentType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class GoRest_UserAPI {
    String apiName = "https://gorest.co.in/public/v1/users/";
    Response apiResponse;
    String headerName = "Authorization";
    String token = "Bearer cb61dc72753d2e6f251cac66e79e98d1a01a6c12f10038b3c93655ebca389d67";
    int id;

    @Given("User api is working and returning {int} status code")
    public void user_api_is_working_and_returning_status_code(int statusCode) {
        int responseCode = given().when().get(apiName).thenReturn().statusCode();
        assertEquals(responseCode, statusCode);
    }

    @When("User wants to add new user with {string}, {string}, {string} and {string}")
    public void user_wants_to_add_new_user_with_and(String name, String email, String gender, String status) {

        JSONObject user = new JSONObject();
        user.put("name", name);
        user.put("email", email);
        user.put("gender", gender);
        user.put("status", status);

        apiResponse = given().header(headerName, token)
                .contentType(ContentType.JSON)
                .and().body(user)
                .when().post(apiName);

        assertEquals(201, apiResponse.statusCode());
        id = apiResponse.jsonPath().getInt("data.id");
    }

    @When("System can verify the new user is added successfully")
    public void system_can_verify_the_new_user_is_added_successfully() {
        assertEquals(200, given().when().get(apiName + id).statusCode());
    }

    @Then("System should cleanUp new user data")
    public void system_should_clean_up_new_user_data() {
        int deleteStat = given().header(headerName, token)
                .when().delete(apiName + id).thenReturn().statusCode();
        assertEquals(204, deleteStat);
    }

    @Then("System should verify that test data user is removed successfully")
    public void system_should_verify_that_test_data_user_is_removed_successfully() {
        assertEquals(404, given().when().get(apiName + id).statusCode());
    }

    @Then("User wants to update the {string} in user details")
    public void user_wants_to_update_the_in_user_details(String updatedEmail) {
        JSONObject updatedUser = new JSONObject();
        updatedUser.put("email", updatedEmail);
        apiResponse = given().header(headerName, token)
                .contentType(ContentType.JSON)
                .and().body(updatedUser)
                .when().put(apiName + id);

        assertEquals(200, apiResponse.statusCode());
    }
}
