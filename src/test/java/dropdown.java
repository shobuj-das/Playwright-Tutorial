import com.microsoft.playwright.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class dropdown extends DriverSetup{

    @Test
    public void dropdown_handle(){
//        Locator dropdown = page.locator("//select[@id='dropdown-class-example']");
        Locator dropdown = page.locator("#dropdown-class-example");
        dropdown.selectOption("option3");
        page.waitForTimeout(2000);
        dropdown.selectOption("Option1");
        System.out.println(page.locator("#dropdown-class-example option:checked").innerText());
        page.waitForTimeout(2000);
        System.out.println(page.locator("#openwindow").innerText());
    }


}
