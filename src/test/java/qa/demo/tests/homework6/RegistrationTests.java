package qa.demo.tests.homework6;

import org.junit.jupiter.api.Test;
import qa.demo.tests.BaseTest;
import qa.demo.tests.TestData;

public class RegistrationTests extends BaseTest {
    TestData studentsData = new TestData();

    @Test
    void studentRegistrationFormTest() {

        registrationPage.openPage()
                .setFirstName(studentsData.firstName)
                .setLastName(studentsData.lastName)
                .setUserEmail(studentsData.userEmail)
                .setGender(studentsData.gender)
                .setPhoneNumber(studentsData.userNumber)
                .setBirthDate(studentsData.dayBirth, studentsData.monthBirth, studentsData.yearBirth)
                .setSubject(studentsData.subject)
                .setHobbiesWrapper(studentsData.hobby)
                .uploadPictureFile(studentsData.pictureDirectory)
                .setCurrentAddress(studentsData.currentAddress)
                .setStateCity(studentsData.state)
                .selectCityInForm(studentsData.city)
                .clickSubmit()
                .verifyResultsModalAppears()
                .checkTableResult("Student Name", studentsData.firstName + " " + studentsData.lastName)
                .checkTableResult("Address", studentsData.currentAddress)
                .checkTableResult("Hobbies", studentsData.hobby)
                .checkTableResult("Student Email", studentsData.userEmail)
                .checkTableResult("Date of Birth", studentsData.dayBirth + " " + studentsData.monthBirth + "," + studentsData.yearBirth)
                .checkTableResult("State and City", studentsData.state + " " + studentsData.city);
    }
}

