package tests;

import data.LoginData;
import data.ProductData;
import data.TestDataProvider;
import io.qameta.allure.Description;
import pages.InventoryPage;
import pages.LoginPage;
import pages.ProductPage;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class InventoryTest extends BaseTest {

    @Test (dataProvider = "productDataWithLoginData", dataProviderClass = TestDataProvider.class)
    @Description("Verify that the buttons on the inventory page change as expected")
    public void verifyInventoryPageItemButtonsFunctionality(LoginData loginData, ProductData productData){
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        login.Login (loginData.getUsername(), loginData.getPassword());
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+InventoryPage.URL_PATH);
        inventory.clickInventoryItemAddToCartButton(productData.getProductName());
        PlaywrightAssertions.assertThat(inventory.getCartItems()).hasText("1");
        PlaywrightAssertions.assertThat(inventory.getItemButton(productData.getProductName(), "add to cart")).not().isVisible();
        inventory.clickInventoryItemRemoveButton(productData.getProductName());
        PlaywrightAssertions.assertThat(inventory.getItemButton(productData.getProductName(), "remove")).not().isVisible();
        PlaywrightAssertions.assertThat(inventory.getCartItems()).not().isVisible();
    }

    @Test (dataProvider = "productDataWithLoginData", dataProviderClass = TestDataProvider.class)
    @Description("Verify that the buttons on the product page change as expected")
    public void verifyProductPageItemButtonsFunctionality(LoginData loginData, ProductData productData){
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        ProductPage productPage = new ProductPage(page);
        login.Login (loginData.getUsername(), loginData.getPassword());
        inventory.clickInventoryItem(productData.getProductName());
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+productPage.URL_PATH+productData.getProductID());
        productPage.clickProductPageAddToCartButton();
        PlaywrightAssertions.assertThat(productPage.getCartItems()).hasText("1");
        PlaywrightAssertions.assertThat(productPage.getAddToCartButton()).not().isVisible();
        productPage.clickProductPageRemoveButton();
        PlaywrightAssertions.assertThat(productPage.getCartItems()).not().isVisible();
    }
}
