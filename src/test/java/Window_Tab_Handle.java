import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

public class Window_Tab_Handle extends DriverSetup{
    @Test
    public void Tab_Handle(){
        Page newTab = page.waitForPopup(()->{
            page.click("#opentab");
        });

        newTab.waitForLoadState();
        System.out.println("New Tab URL: " + newTab.url());
    }

    @Test
    public void create_tab_manually(){
        Page tab2 = page.context().newPage();
        tab2.navigate("https://facebook.com");
        System.out.println(tab2.url());
    }

    @Test
    public void switch_tabs(){
        Page mainTab = page;
        Page secondTab = page.context().newPage();
        secondTab.navigate("https://google.com");
        page.waitForTimeout(3000);
        mainTab.bringToFront();

//        secondTab.close();
        page.waitForTimeout(3000);

    }
//    @Test
//    public void create_window(){
//
//    }
}
