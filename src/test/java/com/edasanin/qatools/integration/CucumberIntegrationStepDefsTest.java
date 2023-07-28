package com.edasanin.qatools.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.edasanin.qatools.QaToolsApplicationTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberIntegrationStepDefsTest extends QaToolsApplicationTests {

    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
    }

}
