package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class Locators {
    private final Page page;

    public Locators(Page page) {
        this.page = page;
    }

    public Locator getButtonByName(String name) {
        return page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(name));
    }

    public Locator getInventoryItemByName(String name) {
        return page.getByTestId("inventory-item-name").getByText(name);
    }
}
