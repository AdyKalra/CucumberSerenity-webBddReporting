package net.thucydides.showcase.cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.cucumber.pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSteps extends ScenarioSteps {

    HomePage homePage;
    SearchResultsPage searchResultsPage;
    LoginPage loginPage;
    JobsPage jobsPage;

    @Step
    public void opens_home_page() {
        loginPage.open();
    }

    @Step
    public void opens_jobs_page() {
        jobsPage.open();
    }

    @Step
    public void clicks_on_likes_until_nomore() {
        homePage.likeUntilReachCount();
    }

    @Step
    public void should_see_people_you_may_know() {
        homePage.shouldStopLikes();
    }

    @Step
    public void logs_into_the_application() {
        loginPage.login();
    }

    @Step
    public void searches_by_keyword(String keyword) {
        homePage.enterSearchTerms(keyword);
        // homePage.search();
    }

    @Step
    public void apply_filter(String keyword) {
        jobsPage.applyFilter(keyword);
    }

    @Step
    public void searches_job__by_keyword(String keyword) {
        jobsPage.enterSearchTerms(keyword);
        jobsPage.search();
    }

    @Step
    public void should_see_tag_in_results(String tag) {
        homePage.shouldSeeYouInResults(tag);
    }

    @Step
    public void should_see_results_summary_containing(String keyword) {
        homePage.search();
        assertThat(searchResultsPage.getResultSummary().contains(keyword));
    }

    @Step
    public void should_see_job_details_for(String keyword) {
        assertThat(searchResultsPage.getResultSummary().contains(keyword));
    }

}
