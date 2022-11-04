package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.ya.olganow.RegistrationFormPage;

public class RegistretionFormTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstNameUser = "Firstname",
            lastNameUser = "Secondname",
            email = "useremail@mail.ma",
            gender = "Female",
            phone = "1234567890",
            yearOfBirth = "1998",
            monthOfbirth = "May",
            dayOfbirth = "16",
            address = "Russia, Spb, 21",
            subjectOne = "Economics",
            subjectSecond = "Biology",
            hobbyOne = "Sports",
            hobbySecond = "Music",
            state = "Uttar Pradesh",
            city = "Lucknow",
            file = "testcat.png";


    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }


    @Test
    void successfulSubmitFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubject(subjectOne, subjectSecond)
                .setHobby(hobbyOne, hobbySecond)
                .uploadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        registrationFormPage
                .checkResultsTableVisible();
        registrationFormPage.checkResult(firstNameUser, lastNameUser, email, gender,
                phone, dayOfbirth, monthOfbirth, yearOfBirth, subjectOne, subjectSecond, hobbyOne, hobbySecond,
                address, state, city, file);

    }

}