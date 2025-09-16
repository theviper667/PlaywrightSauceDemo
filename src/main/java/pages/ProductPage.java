package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.Locators;

public class ProductPage {
    private final Page page;
    private final Locators locators;
    public static final String URL_PATH = "inventory-item.html?id=";

    public ProductPage (Page page) {
        this.page = page;
        this.locators = new Locators(page);
    }

    private Locator getLoginButton(){
        return locators.getButtonByName("Back to products");
    }

    private Locator getProductTitle(String productName){
        return page.getByTestId("inventory-item-name").getByText(productName);
    }

    private Locator getProductDesc(){
        return page.getByTestId("inventory-item-desc");
    }

    private Locator getProductPrice(){
        return page.getByTestId("inventory-item-price");
    }

    public Locator getRemoveButton(){
        return page.getByTestId("remove").getByText("Remove");
    }

    public Locator getAddToCartButton(){
        return page.getByTestId("add-to-cart").getByText("Add to cart");
    }

    public Locator getCartItems() {
        return page.getByTestId("shopping-cart-badge");
    }

    public ProductPage clickProductPageRemoveButton() {
        getRemoveButton().click();
        return this;
    }

    public ProductPage clickProductPageAddToCartButton() {
        getAddToCartButton().click();
        return this;
    }
}
