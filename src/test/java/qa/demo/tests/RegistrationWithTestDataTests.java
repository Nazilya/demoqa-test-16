package qa.demo.tests;

import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithTestDataTests extends BaseTest {

    /*    вариант 2 - когда требуются тест-е данные для разных тестов. Здесь объявляем переменные, а
    внутри каждого теста задаются нужные значения
        String firstName;
        String lastName;
        String userEmail;

        //вариант 3 - когда требуются тест-е данные для разных тестов в BeforeEach перед каждым тестом ген-ся тест-е данные
        @BeforeEach
        void getData() {
            firstName = randomString(8);
            lastName = randomString(12);
            userEmail = randomEmail(12);
            userNumber = randomPhone("7", 1000000, 999999999);
        }
*/
    //вариант 4 - создать отд-й класс TestData.java.
    // Задать значения (либо написать методы, которые генер-ют тест данные), сделать static,
    // а в тест-м классе сделать import этого класса

    @Test
    void studentRegistrationFormTest() {
/*   вариант 1, когда внутри теста объявляем перем-е и сразу задаем значения
    String firstName = "Egor",
            lastName = "Ivanov",
            userEmail = "EgorIvanov@google.com";
            phoneNumber = "1234567890";
*/
/* относится к варианту 2 - когда требуются тест-е данные для разных тестов.
    Выше объявляем переменные, а внутри каждого теста задаются нужные значения
        firstName = "Egor";
        lastName = "Ivanov";
        userEmail = "EgorIvanov@google.com";
*/
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

//        $("#firstName").setValue(firstName);
//        $("#lastName").setValue(lastName);
//        $("#userEmail").setValue(userEmail);
//        $("#genterWrapper").$(byText("Male")).click();
//        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month").click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.jpg"));
        //$("input#cv").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("City, street, 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#city").click();
        $("#city").$(byText("Jaipur")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//        $(".table-responsive").shouldHave(text(firstName), text(lastName), text("EgorIvanov@google.com"),
//                text("14 May,2000"), text("Jaipur"));

        checkTable("Address", "City, street, 1");
        checkTable("Hobbies", "Reading");
    }

    void checkTable(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }

}

