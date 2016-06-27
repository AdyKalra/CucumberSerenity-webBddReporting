package net.thucydides.showcase.cucumber.pages;


import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
@DefaultUrl("http://www.linkedin.com")
public class SearchResultsPage extends PageObject {

    @FindBy(xpath = "//*[@class='search-info']")
    WebElementFacade resultCountSummary;


    //Pattern searchResultSummaryPattern = Pattern.compile("([\\d,]+) Results");

    public String getResultSummary() {
        return resultCountSummary.getText();
    }

    public void filterByLocalRegion() {
    }
}
