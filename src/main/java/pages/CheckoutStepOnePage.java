package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutStepOnePage {
    private final Page page;
    public static final String URL_PATH = "checkout-step-one.html";

    public CheckoutStepOnePage (Page page) {
        this.page = page;
    }

    private Locator getCancelButton(){
        return page.getByTestId("cancel");
    }

    private Locator getContinueButton(){
        return page.getByTestId("continue");
    }

    private Locator getFirstNameTextField(){
        return page.getByPlaceholder("First Name");
    }

    private Locator getLastNameTextField(){
        return page.getByPlaceholder("Last Name");
    }

    private Locator getPostalCodeTextField(){
        return page.getByPlaceholder("Zip/Postal Code");
    }

    public CheckoutStepOnePage fillCustomerDetails (String firstname, String lastname, String zipcode) {
        getFirstNameTextField().fill(firstname);
        getLastNameTextField().fill(lastname);
        getPostalCodeTextField().fill(zipcode);
        return this;
    }

    public CheckoutStepOnePage clickContinueButton () {
        getContinueButton().click();
        return this;
    }
}
