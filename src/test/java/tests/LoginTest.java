package tests;

import data.LoginData;
import data.TestDataProvider;
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
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        login.Login (loginData.getUsername(), loginData.getPassword());
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+InventoryPage.URL_PATH);
        PlaywrightAssertions.assertThat(inventory.getInventoryContainer()).isVisible();
        inventory.clickBurgerMenu()
                .clickLogoutLink();
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL"));
    }

    @Test (dataProvider = "invalidUser", dataProviderClass = TestDataProvider.class)
    @Description ("Attempt to login with invalid credentials and check for error message")
    public void UnSuccessfulLogin (String username, String password) {
        LoginPage login = new LoginPage(page);
        login.Login (username, password);
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL"));
        PlaywrightAssertions.assertThat(login.getErrorMessage()).hasText("Epic sadface: Username and password do not match any user in this service");
    }
}
