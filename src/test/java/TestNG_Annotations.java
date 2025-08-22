import org.testng.annotations.*;

public class TestNG_Annotations{

    @Test
    public void test_code(){
        System.out.println("Actual test");
    }
    @BeforeMethod
    public void test_before_method(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void test_after_method(){
        System.out.println("After Method");
    }

    @BeforeClass
    public void test_before_class(){
        System.out.println("Before class");
    }

    @BeforeTest
    public void test_before_test(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void test_after_test(){
        System.out.println("after Test");
    }

    @BeforeSuite
    public void test_before_suite(){
        System.out.println("Before suite");
    }

    @AfterSuite
    public void test_after_suite(){
        System.out.println("after suite");
    }
}
