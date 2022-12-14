package qa.demo.pages;

import com.codeborne.selenide.SelenideElement;
import qa.demo.elements.Button;
import qa.demo.pages.components.CalendarComponent;
import qa.demo.pages.components.RegistrationResultsModal;
import qa.demo.pages.components.StateAndCityComponent;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            phoneNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            dateOfBirthLocator = $("#dateOfBirthInput");
    Button submit = new Button("Submit", $("#submit"));


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPictureFile(String path) {
        uploadPicture.uploadFile(new File(path));
        return this;
    }


    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public RegistrationPage setStateAndCity(String value1, String value2) {
        stateAndCityComponent.setStateAndCity(value1, value2);

        return this;
    }

    public RegistrationPage clickSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthLocator.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage checkTableResult(String key, String value) {
        registrationResultsModal.checkTable(key, value);
        return this;
    }

}
