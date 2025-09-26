package tests;

import data.LoginData;
import data.TestDataProvider;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import pages.InventoryPage;
import pages.LoginPage;
import com.microsoft.playwright.assertions.*;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test (dataProvider = "validUser", dataProviderClass = TestDataProvider.class)
    @Description ("Login with valid credentials then logout")
    public void SuccessfulLoginAndLogout (LoginData loginData) {
        String inventoryUrl = ConfigReader.get("baseURL")+InventoryPage.URL_PATH;
        Allure.step("Filling in valid username "+loginData.getUsername()+" and password "+loginData.getPassword());
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        login.Login (loginData.getUsername(), loginData.getPassword());
        Allure.step("Verifying the URL is "+inventoryUrl+" and the inventory grid is visible");
        PlaywrightAssertions.assertThat(page).hasURL(inventoryUrl);
        PlaywrightAssertions.assertThat(inventory.getInventoryContainer()).isVisible();
        Allure.step("Verifying we can logout and return to the base page "+ConfigReader.get("baseURL"));
        inventory.clickBurgerMenu()
                .clickLogoutLink();
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL"));
    }

    @Test (dataProvider = "invalidUser", dataProviderClass = TestDataProvider.class)
    @Description ("Attempt to login with invalid credentials and check for error message")
    public void UnSuccessfulLogin (String username, String password) {
        Allure.step("Logging in with invalid username "+username+" and password "+password);
        LoginPage login = new LoginPage(page);
        login.Login (username, password);
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL"));
        PlaywrightAssertions.assertThat(login.getErrorMessage()).hasText("Epic sadface: Username and password do not match any user in this service");
    }
}
