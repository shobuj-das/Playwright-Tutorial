import org.testng.annotations.Test;

import java.nio.file.Paths;

public class file_upload extends DriverSetup{
    @Test
    public void test_file_upload(){
        page.navigate("https://the-internet.herokuapp.com/upload");

        page.setInputFiles("//input[@type='file']", Paths.get("C:/Users/TechnoNext/Downloads/ISTQB_CTFL_Syllabus_v4.0.1.pdf"));
        page.click("#file-submit");

        page.waitForTimeout(2000);

    }
}
