package tests;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;


    @BeforeMethod
    public void setup(){
        Allure.step("Creating a playwright instance that uses a visible browser for tests and navigating to "+ConfigReader.get("baseURL"));
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate(ConfigReader.get("baseURL"));
        //Sets the default test-id selector to data-test so the method can be used with our site
        playwright.selectors().setTestIdAttribute("data-test");
    }

    @AfterMethod
    public void tearDown() {
        Allure.step("Closing browser and playwright instances if they are not already null");
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
