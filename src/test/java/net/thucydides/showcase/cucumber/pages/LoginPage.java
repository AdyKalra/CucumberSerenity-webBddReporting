package net.thucydides.showcase.cucumber.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

//import org.openqa.selenium.WebElement;

/**
 * Created by Ady on 19/11/15.
 */
@DefaultUrl("http://www.linkedin.com")
public class LoginPage extends PageObject {

    //public static final String PRODUCT_OPTIONS_DROPDOWN = ".variation";

    @FindBy(xpath = "//*[@id='login-email']")
    WebElementFacade email;

    @FindBy(xpath = "//*[@id='login-password']")
    WebElementFacade password;

    @FindBy(xpath = "//*[@name='submit']")
    WebElementFacade signIn;

    public void login() {
        email.typeAndTab("aditya_kalra@ymail.com");
        password.typeAndEnter("password");
    }


}
