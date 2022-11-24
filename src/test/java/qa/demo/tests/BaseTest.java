package qa.demo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import qa.demo.pages.RegistrationPage;

public class BaseTest {
    protected RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000;  //10 сек
//        Configuration.browser = "opera";
    }

}