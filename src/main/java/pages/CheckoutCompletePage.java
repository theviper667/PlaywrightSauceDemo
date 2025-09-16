package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;

public class CheckoutCompletePage {
    private final Page page;
    private final Locators locators;

    public CheckoutCompletePage (Page page) {
        this.page = page;
        this.locators = new Locators(page);
    }

    private Locator getCompleteOrderHeader(){
        return page.getByTestId("complete-header").getByText("Thank you for your order!");
    }

    private Locator getCompleteOrderText(){
        return page.getByTestId("complete-text");
    }

    private Locator getFinishButton(){
        return page.getByTestId("back-to-products").getByText("Back Home");
    }

    public void clickFinishButton() {
        getFinishButton().click();
    }
}
