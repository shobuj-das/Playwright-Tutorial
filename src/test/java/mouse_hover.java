import org.testng.annotations.Test;

public class mouse_hover extends DriverSetup{
    @Test
    public void hover_on_element(){
        page.locator("#mousehover").hover();
        page.waitForTimeout(2000);

        page.locator("//a[text()='Reload']").click();
        page.waitForTimeout(2000);

        page.locator("#mousehover").hover();
        page.waitForTimeout(2000);

        page.locator("//a[text()='Top']").click();
        page.waitForTimeout(2000);
    }
}
