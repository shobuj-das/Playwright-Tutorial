import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class form_submit {
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


        page.navigate("https://demoqa.com/automation-practice-form");
    }
    @Test
    public void submit_form(){
        page.waitForTimeout(2000);
        String firstName = "//input[@placeholder='First Name']";

//        page.locator(firstName).click();
        page.locator(firstName).fill("John");
        page.waitForTimeout(2000);

        page.locator("//input[@placeholder='Last Name']").fill("The Riper");
        page.locator("//input[@id='userEmail']").fill("john@example.com");
        page.locator("//label[@for='gender-radio-1']").click();
        page.locator("//input[@id='userNumber']").fill("1122334455");
        page.locator("//input[@id='dateOfBirthInput']").fill("25 Feb 2025");
        page.locator("//div[text()='25']").click();
        page.locator("//input[@id='subjectsInput']").fill("CSE Engg.");
        page.locator("//label[@for='hobbies-checkbox-2']").click();
        page.locator("//textarea[@id='currentAddress']").fill("Dhaka, Bangladesh");
        page.waitForTimeout(2000);

        page.locator("//button[@id='submit']").click();
        page.waitForTimeout(3000);

    }

    @AfterSuite
    public void quit_browser(){
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

}
