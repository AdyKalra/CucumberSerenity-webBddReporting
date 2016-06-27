package net.thucydides.showcase.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.steps.serenity.UserSteps;

public class JobScenarioSteps {

    @Steps
    UserSteps user;

    @Given("^I am on the jobs page$")
    public void I_am_on_the_jobs_page() throws Throwable {
        user.opens_home_page();
        user.logs_into_the_application();
        user.opens_jobs_page();
    }


    @Then("^I should see '(.*)' description on the results page$")
    public void I_should_see_job_description_on_the_results_page(String keyword) throws Throwable {
        user.should_see_job_details_for(keyword);

    }

    @When("^I search a '(.*)' from jobs page$")
    public void I_search_a_job_from_jobs_page(String keyword) throws Throwable {
        user.searches_job__by_keyword(keyword);
    }

    @And("^I apply a filter on '(.*)'$")
    public void I_apply_a_filter_on_location_(String keyword) throws Throwable {
       user.apply_filter(keyword);
    }
}
