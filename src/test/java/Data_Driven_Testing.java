import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Driven_Testing extends DriverSetup{
    @DataProvider(name = "Login_credentials")
    public Object[][] testData(){
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "Login_credentials")
    public void test_login(String username, String password){
        page.navigate("https://www.saucedemo.com/");

        page.locator("#user-name").fill(username);
        page.locator("#password").fill(password);
        page.locator("#login-button").click();

        Assert.assertEquals(page.url(), "https://www.saucedemo.com/inventory.html");
    }


    @DataProvider(name = "invalid_login_data")
    public Object[][] invalid_login_test(){
        return new Object[][]{
                {"standard_user", "invalidpass", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"invalidUser", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"invalidUser", "invalidPass", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"", "", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "invalid_login_data")
    public void test_invalid_login(String username, String password, String expErrMgs){
        page.navigate("https://www.saucedemo.com/");

        page.locator("#user-name").fill(username);
        page.locator("#password").fill(password);
        page.locator("#login-button").click();
        String actulaErrMgs = page.locator("//h3[@data-test='error']").innerText();
        Assert.assertEquals(actulaErrMgs, expErrMgs, "Error message mismatched");
    }
}
