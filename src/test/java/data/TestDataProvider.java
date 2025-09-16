package data;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    //Simple data provider for readability
    @DataProvider(name="invalidUser")
    public static Object[] [] getInvalidUser() {
        return new Object[][] {
                {"invaliduser", "secret_mustard"}
        };
    }

    //More complex data objects for when addressing properties directly is better
    @DataProvider(name="validUser")
    public static Object[] [] getValidUser() {
        return new Object[][] {
                {new LoginData("standard_user", "secret_sauce")}
        };
    }

    @DataProvider(name="productData")
    public static Object[] [] getProductData() {
        return new Object[][] {
                {new ProductData("Sauce Labs Bike Light","0")}
        };
    }

    @DataProvider(name="productDataWithLoginData")
    public static Object[] [] getProductDataAndLoginData() {
        LoginData loginData = (LoginData) getValidUser()[0][0];
        ProductData productData = (ProductData) getProductData()[0][0];
        return new Object[][]{
                {loginData, productData}
        };
    }
}
