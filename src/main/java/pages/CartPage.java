package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.Locators;

public class CartPage extends BasePage{
    private final Page page;
    private final Locators locators;
    public static final String URL_PATH = "cart.html";

    public CartPage (Page page) {
        this.page = page;
        this.locators = new Locators(page);
    }

    public Locator getProductTitle(String productName){
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

    public CartPage clickCheckoutButton() {
        getCheckoutButton().click();
        return this;
    }

    public CartPage clickContinueShoppingButton() {
        getContinueShoppingButton().click();
        return this;
    }

    public CartPage clickProductRemoveButton(String productName) {
        getProductRemoveButton(productName).click();
        return this;
    }
}
