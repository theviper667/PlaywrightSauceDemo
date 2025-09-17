package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;

public class CheckoutCompletePage {
    private final Page page;
    public static final String URL_PATH = "checkout-complete.html";

    public CheckoutCompletePage (Page page) {
        this.page = page;
    }

    public Locator getCompleteOrderHeader(){
        return page.getByTestId("complete-header").getByText("Thank you for your order!");
    }

    public Locator getCompleteOrderText(){
        return page.getByTestId("complete-text");
    }

    private Locator getBackHomeButton(){
        return page.getByTestId("back-to-products").getByText("Back Home");
    }

    public void clickBackHomeButton() {
        getBackHomeButton().click();
    }
}
