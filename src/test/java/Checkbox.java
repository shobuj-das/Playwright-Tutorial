import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

public class Checkbox extends DriverSetup{
    @Test
    public void checkbox_test(){
        Locator op1 = page.locator("#checkBoxOption1");
        op1.click();
        System.out.println("option1: "+ op1.isChecked());
        op1.click();
        System.out.println("option1: "+ op1.isChecked());

        Locator op2 = page.locator("#checkBoxOption1");
        op2.click();
        System.out.println("option2: "+ op2.isChecked());

        System.out.println(page.locator("#checkBoxOption3").isDisabled());

    }
}
