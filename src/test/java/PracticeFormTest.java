import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class PracticeFormTest {
    public static void main(String[] args) {
        Playwright playwright;
        Browser browser;
        BrowserContext context;
        Page page;

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        page = context.newPage();


        page.navigate("https://demoqa.com/automation-practice-form");

        page.waitForTimeout(2000);
        String firstName = "//input[@placeholder='First Name']";
//        String lastName = "#firstName";
//        String email = "#userEmail";
//        String male = "#gender-radio-1";
//        String mobile = "#userNumber";
//        String date = "#dateOfBirthInput";
//        String subject_input = "#subjectsInput";


        page.locator(firstName).click();
        page.locator(firstName).fill("John");
        page.waitForTimeout(2000);

        page.locator("//textarea[@id='currentAddress']").fill("Dhaka, Bangladesh");
        page.waitForTimeout(2000);

        page.locator("//button[@id='submit']").click();
        page.waitForTimeout(3000);

        page.close();
        context.close();
        browser.close();
        playwright.close();


    }
}
