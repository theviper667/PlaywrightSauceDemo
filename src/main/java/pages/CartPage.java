package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.Locators;

public class CartPage extends BasePage{
    private final Page page;
    private final Locators locators;

    public CartPage (Page page) {
        this.page = page;
        this.locators = new Locators(page);
    }

    private Locator getProductTitle(String productName){
        return page.getByTestId("inventory-item-name").getByText(productName);
    }

    private Locator getContinueShoppingButton(){
        return locators.getButtonByName("Continue Shopping");
    }

    private Locator getCheckoutButton(){
        return locators.getButtonByName("Checkout");
    }

    private Locator getProductRemoveButton(String productName){
        return page.getByTestId("cart-item")
                .filter(new Locator.FilterOptions().setHasText(productName))
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName("remove"));
    }

    public void clickCheckoutButton() {
        getCheckoutButton().click();
    }

    public void clickContinueShoppingButton() {
        getContinueShoppingButton().click();
    }

    public void clickProductRemoveButton(String productName) {
        getProductRemoveButton(productName).click();
    }

}
