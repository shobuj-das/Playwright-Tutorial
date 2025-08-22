import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    @BeforeSuite
    public void Driver(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        page = context.newPage();

//        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
//        page.navigate("https://www.saucedemo.com/");
    }

    @AfterSuite
    public void quit_browser(){
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }
}
