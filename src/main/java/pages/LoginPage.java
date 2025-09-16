package pages;
import com.microsoft.playwright.*;
import utils.Locators;

public class LoginPage extends BasePage {
    private static Page page;
    private final Locators locators;

    public LoginPage (Page page) {
        LoginPage.page = page;
        this.locators = new Locators(page);
    }

    private Locator getUserNameTextField(){
        return page.getByPlaceholder("Username");
    }

    private Locator getLoginLogo(){
        return page.locator(".login_logo");
    }

    private Locator getPasswordTextField(){
        return page.getByPlaceholder("Password");
    }

    private Locator getLoginButton(){
        return locators.getButtonByName("Login");
    }

    public Locator getErrorMessage(){
        return page.getByTestId("error");
    }

    public LoginPage Login(String username, String password) {
        getUserNameTextField().fill(username);
        getPasswordTextField().fill(password);
        getLoginButton().click();
        return this;
    }
}
