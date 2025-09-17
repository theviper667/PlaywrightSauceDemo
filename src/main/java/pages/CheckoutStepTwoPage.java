package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;

public class CheckoutStepTwoPage {
    private final Page page;
    public static final String URL_PATH = "checkout-step-two.html";

    public CheckoutStepTwoPage (Page page) {
        this.page = page;
    }

    public Locator getProductTitle(String productName){
        return page.getByTestId("inventory-item-name").getByText(productName);
    }

    private Locator getFinishButton(){
        return page.getByTestId("finish");
    }

    public CheckoutStepTwoPage clickFinishButton() {
        getFinishButton().click();
        return this;
    }
}
