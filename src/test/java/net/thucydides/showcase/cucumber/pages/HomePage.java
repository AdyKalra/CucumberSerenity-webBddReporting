package net.thucydides.showcase.cucumber.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("http://www.linkedin.com")
public class HomePage extends PageObject {

    @FindBy(id = "main-search-box")
    WebElementFacade searchQueryBox;

    @FindBy(name = "search")
    WebElementFacade searchButton;

    @FindBy(xpath = "//*[@class='typeahead-degree']")
    WebElementFacade userIsYou;

    @FindBy(xpath = "//*[@id='props']/li[1]/div/ul/li[1]/button")
    WebElementFacade likeButton;

    @FindBy(xpath = "//*[@id='props']")
    WebElementFacade likeCard;

    @FindBy(xpath = ".//*[@class='connect']")
    WebElementFacade connectButton;


    public void enterSearchTerms(String keyword) {
        searchQueryBox.type(keyword);
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@title='" + keyword + "']"));
        waitForKeywordToBeUpdatedTo(keyword);
    }

    private void waitForKeywordToBeUpdatedTo(String keyword) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .until(keywordFieldIsUpdatedTo(keyword));
    }

    private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
        return webDriver -> searchQueryBox.getValue().equalsIgnoreCase(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public void shouldSeeYouInResults(String tagName) {
        assertThat(userIsYou.isPresent());
        assertThat(userIsYou.containsText(tagName));
    }

    public void likeUntilReachCount(){
        int i=1;
        while (!connectButton.isPresent()){
            like(i);
            i=i+1;
        }
    }

    public void shouldStopLikes() {
        assertThat(connectButton.isPresent());
    }

    public void like(int i) {
        $("//*[@id='props']/li["+i+"]/div/ul/li[1]/button").click();
        //likeButton.click();
    }




}