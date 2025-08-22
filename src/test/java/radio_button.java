import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

public class radio_button extends DriverSetup{
    @Test
    public void radio_button_test(){
//        page.click(".radioButton");
        Locator radio1 = page.locator("//input[@value='radio1']");
        radio1.click();
        System.out.println(radio1.isChecked());

        Locator radio2 = page.locator("//input[@value='radio2']");
        radio2.click();
        System.out.println(radio1.isChecked());
        System.out.println(radio2.isChecked());
    }
}
