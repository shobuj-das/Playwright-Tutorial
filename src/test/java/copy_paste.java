import org.testng.annotations.Test;

public class copy_paste extends DriverSetup{
    @Test
    public void copy_paste_text(){
        page.locator("#autocomplete").fill("Shobuj Das");
        page.waitForTimeout(2000);
        page.locator("#autocomplete").press("Control+A");
        page.locator("#autocomplete").press("Control+C");
        page.locator("#name").press("Control+V");
        page.waitForTimeout(2000);

        page.locator("#autocomplete").clear();
        page.waitForTimeout(2000);
    }

    @Test
    public void using_keyboard(){
        page.click("#autocomplete");
        page.keyboard().type("Hello World");
        page.keyboard().press("Control+A");
        page.keyboard().press("Control+C");
        page.waitForTimeout(2000);
        page.click("#name");
        page.keyboard().press("Control+V");
        page.waitForTimeout(2000);
    }
}
