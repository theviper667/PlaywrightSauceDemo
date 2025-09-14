package org.example;

import com.microsoft.playwright.*;

public class Main {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://www.saucedemo.com/");
            System.out.println(page.title());
            //page.close();
            //browser.close();
            //playwright.close();
        }
    }
}