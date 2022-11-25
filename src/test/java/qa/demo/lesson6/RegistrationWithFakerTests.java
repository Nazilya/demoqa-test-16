package qa.demo.lesson6;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import qa.demo.tests.BaseTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static qa.demo.tests.TestData.*;

public class RegistrationWithFakerTests extends BaseTest {

    @Test
    void studentRegistrationFormTest() {
        open("/automation-practice-form");

        //Faker faker = new Faker(new Locale("ru"));
        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String[] birthDay = dateFormat.format(faker.date().birthday()).split(" ");

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                currentAddress = faker.address().fullAddress();

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        //$("input#cv").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaipur")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text("EgorIvanov@google.com"),
                text("14 May,2000"), text("Jaipur"));

        checkTable("Address", "City, street, 1");
        checkTable("Hobbies", "Reading");
    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}

