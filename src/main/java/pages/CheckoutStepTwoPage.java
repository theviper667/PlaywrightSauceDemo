package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;

public class CheckoutStepTwoPage {
    private final Page page;
    private final Locators locators;

    public CheckoutStepTwoPage (Page page) {
        this.page = page;
        this.locators = new Locators(page);
    }

    private Locator getProductTitle(String productName){
        return page.getByTestId("inventory-item-name").getByText(productName);
    }

    private Locator getFinishButton(){
        return page.getByTestId("finish");
    }
}
