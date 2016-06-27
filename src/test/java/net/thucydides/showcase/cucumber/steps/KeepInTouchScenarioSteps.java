package net.thucydides.showcase.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.steps.serenity.UserSteps;

/**
 * Created by Ady on 24/11/15.
 */
public class KeepInTouchScenarioSteps {

    @Steps
    UserSteps user;

    @Given("^I am on the home page$")
    public void I_am_on_the_home_page() throws Throwable {
        user.opens_home_page();
        user.logs_into_the_application();
    }

    @When("^I click on likes$")
    public void I_click_on_likes() throws Throwable {
        user.clicks_on_likes_until_nomore();
    }

    @Then("^I should like until I have no more options$")
    public void I_should_like_until_I_have_no_more_options() throws Throwable {
        user.should_see_people_you_may_know();
    }
}
