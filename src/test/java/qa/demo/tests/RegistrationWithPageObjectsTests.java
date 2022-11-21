package qa.demo.tests;

import org.junit.jupiter.api.Test;
public class RegistrationWithPageObjectsTests extends BaseTest {
    @Test
    void studentRegistrationFormTest() {
        String firstName = "Egor";
        String lastName = "Ivanov";
        String email = "EgorIvanov@google.com";
        String gender = "Male";
        String phoneNumber = "1234567890";
        String dayBirth = "30";
        String monthBirth = "May";
        String yearBirth = "2000";
        String subject = "English";
        String hobbies = "Reading";
        String pictureDirectory = "src/test/resources/cat.jpg";
        String address = "City, street, 1";
        String state = "Rajasthan";
        String city = "Jaipur";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(dayBirth, monthBirth, yearBirth)
                .setSubject(subject)
                .setHobbiesWrapper(hobbies)
                .uploadPictureFile(pictureDirectory)
                .setCurrentAddress(address)
                .setStateCity(state)
                .selectCityInForm(city)
                .clickSubmit()
                .verifyResultsModalAppears()
                .checkTableResult("Student Name", firstName + " " + lastName)
                .checkTableResult("Address", address)
                .checkTableResult("Hobbies", "Reading")
                .checkTableResult("Student Email", email)
                .checkTableResult("Date of Birth", dayBirth+" "+ monthBirth+","+yearBirth)
                .checkTableResult("State and City", state + " " + city);
    }
}

