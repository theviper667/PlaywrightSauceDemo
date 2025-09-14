import business.pages.BasePage;
import business.pages.InventoryPage;
import business.pages.LoginPage;
import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void SuccessfulLogin () {
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        login.Login ("standard_user", "secret_sauce");
        PlaywrightAssertions.assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
        PlaywrightAssertions.assertThat(inventory.getInventoryContainer()).isVisible();
        inventory.clickBurgerMenu()
                .clickLogoutLink();
        PlaywrightAssertions.assertThat(page).hasURL("https://www.saucedemo.com/");
    }

    @Test
    public void UnSuccessfulLogin () {
        LoginPage login = new LoginPage(page);
        login.Login ("test", "secret_mustard");
        PlaywrightAssertions.assertThat(page).hasURL("https://www.saucedemo.com/");
        PlaywrightAssertions.assertThat(login.getErrorMessage()).hasText("Epic sadface: Username and password do not match any user in this service");
    }
}
