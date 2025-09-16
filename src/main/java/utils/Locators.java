package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Locators {
    private final Page page;

    public Locators(Page page) {
        this.page = page;
    }

    //Demonstrating how a util method can help readability of code (Though this is not a very lengthy statement)
    public Locator getButtonByName(String name) {
        return page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(name));
    }
}
