package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;
import utilities.RestAssuredExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class POSTProfileSteps {

    private static ResponseOptions<Response> response;

    @Given("I ensure to Perform POST operation for {string} with body as")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, DataTable table) {

        Map<String, String> body = new HashMap<>();

        body.put("id", table.cell(1, 0));
        body.put("title", table.cell(1, 1));
        body.put("author", table.cell(1, 2));

        // Perform post operation
        RestAssuredExtension.PostOpsWithBody(url, body);
    }

    @And("I Perform DELETE operation for {string}")
    public void iPerformDELETEOperationFor(String url, DataTable table) {

       Map<String, String> pathParams = new HashMap<>();
       pathParams.put("postid", table.cell(1, 0));

       //Perform Delete operation
        RestAssuredExtension.DeleteOpsWithPathParams(url, pathParams);
    }

    @And("I perform GET operation with path parameter for {string}")
    public void iPerformGETOperationWithPathParameterFor(String url, DataTable table) {

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", table.cell(1, 0));

        response = RestAssuredExtension.GetWithPathParams(url, pathParams);
    }

    @Then("I {string} see the body with title as {string}")
    public void iSeeTheBodyWithTitleAs(String title, String arg1) {
        assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
    }
}
