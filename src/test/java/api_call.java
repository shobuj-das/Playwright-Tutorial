import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class api_call {
    @Test
    public void get_api(){
        try(Playwright playwright = Playwright.create()){
            APIRequestContext request = playwright.request().newContext();

            APIResponse response = request.get("https://restful-booker.herokuapp.com/booking");
            System.out.println("Status: " + response.status());
            System.out.println("Body: "+ response.text());
        }
    }

    @Test
    public void post_api(){
        try(Playwright playwright = Playwright.create()){
            APIRequestContext request = playwright.request().newContext();

            Map<String, Object>bookingDates = new HashMap<>();
            bookingDates.put("checkin", "2018-01-01");
            bookingDates.put("checkout", "2018-08-01");

            Map<String , Object> body_data = new HashMap<>();
            body_data.put("firstname", "Shobuj");
            body_data.put("lastname", "Das");
            body_data.put("totalprice", 1212);
            body_data.put("depositpaid", true);
            body_data.put("bookingdates", bookingDates);
            body_data.put("additionalneeds", "Breakfast");

            APIResponse response = request.post("https://restful-booker.herokuapp.com/booking",
                    RequestOptions.create()
                            .setHeader("Content-Type", "application/json")
                            .setHeader("Accept", "application/json")
                            .setData(body_data)
                    );

            System.out.println(response.status());
            System.out.println(response.text());
        }
    }
}
