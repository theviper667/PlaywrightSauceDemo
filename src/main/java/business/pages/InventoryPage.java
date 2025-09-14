package business.pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import utils.Locators;

import java.util.regex.Pattern;

public class InventoryPage extends BasePage {
    private final Page page;
    private final Locators locators;

    public InventoryPage (Page page){
        this.page = page;
        this.locators = new Locators(page);
    }

    private Locator getSwagLabsLogo(){
        return page.locator(".app_logo").getByText("Swag Labs");
    }

    private Locator getBurgerMenuButton(){
        return page.locator("#react-burger-menu-btn");
    }

    private Locator getLogoutLink(){
        return page.getByTestId("logout-sidebar-link").getByText("Logout");
    }

    public Locator getInventoryContainer(){
        return page.locator(".inventory_container");
    }

    private Locator getInventoryItemByName(String name) {
        return page.getByTestId("inventory-item-name").getByText(name);
    }

    private Locator getInventoryItemRemoveButton(String name) {
        return getItemButton(name, "remove");
    }

    private Locator getInventoryItemAddToCartButton(String name) {
        return getItemButton(name, "add to cart");
    }

    public Locator getCartItems() {
        return page.getByTestId("shopping-cart-badge");
    }

    private Locator getInventoryItemLink(){
        return page.getByTestId("inventory-item-price");
    }

    public InventoryPage clickBurgerMenu() {
        getBurgerMenuButton().click();
        return this;
    }

    public InventoryPage clickLogoutLink() {
        getLogoutLink().click();
        return this;
    }

    public InventoryPage clickInventoryItem(String productName){
        getInventoryItemByName(productName).click();
        return this;
    }

    //Helper method to abstract repetitive code for inventory item buttons
    public Locator getItemButton(String itemName, String buttonName) {
        return page.getByTestId("inventory-item")
                .filter(new Locator.FilterOptions().setHasText(itemName))
                .getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions()
                        .setName(Pattern.compile(buttonName, Pattern.CASE_INSENSITIVE)));
    }

    public InventoryPage clickInventoryItemRemoveButton(String productName) {
        getInventoryItemRemoveButton(productName).click();
        return this;
    }

    public InventoryPage clickInventoryItemAddToCartButton(String productName) {
        getInventoryItemAddToCartButton(productName).click();
        return this;
    }
}
