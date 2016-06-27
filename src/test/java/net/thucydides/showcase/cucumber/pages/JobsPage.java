package net.thucydides.showcase.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

/**
 * Created by Ady on 26/11/15.
 */

@DefaultUrl("http://www.linkedin.com/job/home?trk=nav_responsive_sub_nav_jobs")
public class JobsPage extends PageObject {

    @FindBy(xpath = "//*[@id='job-search-box']")
    WebElementFacade jobSearchBox;

    @FindBy(xpath = "(.//*[@class='search-button' and @type='submit' and @name='jsearch'])[2]")
    WebElementFacade searchButton;


    public void enterSearchTerms(String keyword) {
        jobSearchBox.type(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public void applyFilter(String keyword) {
        $("//*[@class='facet-label' and  contains(@title,'"+keyword+"')]").click();
    }




}


