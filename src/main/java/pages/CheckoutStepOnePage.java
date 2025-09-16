package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;

public class CheckoutStepOnePage {
    private final Page page;
    private final Locators locators;

    public CheckoutStepOnePage (Page page) {
        this.page = page;
        this.locators = new Locators(page);
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
}
