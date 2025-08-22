import com.microsoft.playwright.*;

public class test {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://google.com");
            System.out.println("Page title is: " + page.title());
            browser.close();
        }
    }
}