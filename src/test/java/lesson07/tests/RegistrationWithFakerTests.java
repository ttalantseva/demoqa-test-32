package lesson07.tests;

import org.junit.jupiter.api.Test;
import lesson07.pages.RegistrationPage;
import lesson07.pages.components.CheckResultRegistrationPage;
import lesson07.utils.TestData;


public class RegistrationWithFakerTests extends TestBase {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final CheckResultRegistrationPage checkResult = new CheckResultRegistrationPage();


    @Test
    void fullRegistrationTest() {
        TestData testData = new TestData();

        registrationPage.open()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGenderSelector(testData.gender)
                .setMobileSelector(testData.userMobileNumber)
                .setDataOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.subject1)
                .setSubject(testData.subject2)
                .setHobby(testData.hobbies)
                .uploadPicture(testData.uploadImage)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .register();


        checkResult.resultCheck("Student Name", testData.firstName + " " + testData.lastName)
                .resultCheck("Student Email", testData.userEmail)
                .resultCheck("Gender", testData.gender)
                .resultCheck("Mobile", testData.userMobileNumber)
                .resultCheck("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                .resultCheck("Subjects", testData.subject1 + "," + " " + testData.subject2)
                .resultCheck("Hobbies", testData.hobbies)
                .resultCheck("Picture", testData.uploadImage)
                .resultCheck("Address", testData.currentAddress)
                .resultCheck("State and City", testData.state + " " + testData.city);

    }

    @Test
    void minDataTest() {

        TestData testData = new TestData();

        registrationPage.open()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderSelector(testData.gender)
                .setMobileSelector(testData.userMobileNumber)
                .setDataOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .register();

        checkResult.resultCheck("Student Name", testData.firstName + " " + testData.lastName)
                .resultCheck("Gender", testData.gender)
                .resultCheck("Mobile", testData.userMobileNumber)
                .resultCheck("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth);
    }

    @Test
    void minDataNegativeTest() {

        TestData testData = new TestData();

        registrationPage.open()
                .removeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGenderSelector(testData.gender)
                .setMobileSelector("")
                .setDataOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .register();

        checkResult.negativeResultCheck();

    }
}
