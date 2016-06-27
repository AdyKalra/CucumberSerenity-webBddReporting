package net.thucydides.showcase.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.steps.serenity.UserSteps;

public class SearchScenarioSteps {
    @Steps
    UserSteps user;

    @Given("I (?:want|would like) to see my own profile")
    public void wantToSeeMyProfile() throws Throwable {
        user.opens_home_page();
        user.logs_into_the_application();

    }

    @When("I search for '(.*)'")
    public void searchByKeyword(String keyword) {
        user.searches_by_keyword(keyword);
    }

    @Then("I should see (?:only|) my profile with a tag '(.*)'")
    public void I_should_see_only_my_profile_with_a_tag_You(String tag) throws Throwable {
        user.should_see_tag_in_results(tag);
    }

    @Given("I would like to search about (?:a|an) company")
    public void I_would_like_to_search_about_a_company() throws Throwable {
        user.opens_home_page();
        user.logs_into_the_application();
    }

    @Then("I should see (?:only|) items related to '(.*)'")
    public void I_should_see_only_items_related_to_company_(String company) throws Throwable {
        user.should_see_results_summary_containing(company);
    }
}




