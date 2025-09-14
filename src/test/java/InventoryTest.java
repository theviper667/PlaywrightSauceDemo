import business.pages.InventoryPage;
import business.pages.LoginPage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyInventoryItemButtonsFunctionality(){
        String product = "Sauce Labs Bike Light";
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        login.Login ("standard_user", "secret_sauce");
        PlaywrightAssertions.assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
        inventory.clickInventoryItemAddToCartButton(product);
        PlaywrightAssertions.assertThat(inventory.getCartItems()).hasText("1");
        PlaywrightAssertions.assertThat(inventory.getItemButton(product, "add to cart")).not().isVisible();
        inventory.clickInventoryItemRemoveButton(product);
        PlaywrightAssertions.assertThat(inventory.getItemButton(product, "remove")).not().isVisible();
    }
}
