package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import data.DeliveryDetailsData;
import data.LoginData;
import data.ProductData;
import data.TestDataProvider;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test (dataProvider = "checkoutFlowData", dataProviderClass = TestDataProvider.class)
    public void SuccessfulItemPurchase(LoginData loginData, ProductData productData, DeliveryDetailsData deliveryDetailsData){
        LoginPage login = new LoginPage(page);
        InventoryPage inventory = new InventoryPage(page);
        CartPage cart = new CartPage(page);
        CheckoutStepOnePage stepone = new CheckoutStepOnePage(page);
        CheckoutStepTwoPage steptwo = new CheckoutStepTwoPage(page);
        CheckoutCompletePage success = new CheckoutCompletePage(page);
        login.Login (loginData.getUsername(), loginData.getPassword());
        inventory.clickInventoryItemAddToCartButton(productData.getProductName())
                .clickCartButton();
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+CartPage.URL_PATH);
        PlaywrightAssertions.assertThat(cart.getProductTitle(productData.getProductName())).isVisible();
        cart.clickCheckoutButton();
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+ CheckoutStepOnePage.URL_PATH);
        stepone.fillCustomerDetails(deliveryDetailsData.getFirstName(), deliveryDetailsData.getLastName(), deliveryDetailsData.getZipCode())
                .clickContinueButton();
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+ CheckoutStepTwoPage.URL_PATH);
        PlaywrightAssertions.assertThat(steptwo.getProductTitle(productData.getProductName())).isVisible();
        steptwo.clickFinishButton();
        PlaywrightAssertions.assertThat(page).hasURL(ConfigReader.get("baseURL")+ CheckoutCompletePage.URL_PATH);
        PlaywrightAssertions.assertThat(success.getCompleteOrderHeader()).isVisible();
        PlaywrightAssertions.assertThat(success.getCompleteOrderText()).isVisible();
        success.clickBackHomeButton();
    }
}
