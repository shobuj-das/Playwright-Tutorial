import org.testng.annotations.Test;

public class Alert extends DriverSetup{
    @Test
    public void alert_test(){
//        page.locator("#alertbtn").click();

        page.onceDialog(dialog -> {
            System.out.println("message: " + dialog.message());
            page.waitForTimeout(2000);
            dialog.accept();
        });
        page.click("#alertbtn");
    }

    @Test
    public void alert_confirm_cancel_test(){

        page.onceDialog(dialog -> {
            System.out.println("message: " + dialog.message());
            dialog.dismiss();
        });
        page.locator("#confirmbtn").click();
    }
}
