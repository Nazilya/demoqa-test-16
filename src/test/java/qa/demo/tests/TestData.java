package qa.demo.tests;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Locale;
import static qa.demo.utils.RandomUtils.*;

public class TestData {
    Faker faker = new Faker();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    String[] birthDay = dateFormat.format(faker.date().birthday()).split(" ");
    String[] subjects = {"English", "Math", "Arts", "Physics", "Chemistry", "Economics", "Biology"};
    String[] hobbies = {"Sports", "Reading", "Music"};
    String[] months = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December"};

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            yearBirth = String.valueOf(faker.number().numberBetween(1912, 2012)),
            monthBirth = getMonth(),
            dayBirth = String.valueOf(faker.number().numberBetween(1, 28)),
            currentAddress = faker.address().streetName() + ", "
                    + faker.address().buildingNumber(),
            hobby = getHobbies(),
            subject = getSubject(),
            gender = "Other",
            pictureDirectory = "src/test/resources/cat.jpg",
            state = "Rajasthan",
            city = "Jaipur";
}
