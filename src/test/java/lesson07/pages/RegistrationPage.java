package lesson07.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lesson07.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final static String URL = "/automation-practice-form";

    private final SelenideElement firstNameSelector = $("#firstName");
    private final SelenideElement lastNameSelector = $("#lastName");
    private final SelenideElement genderSelector = $("#genterWrapper");
    private final SelenideElement mobileSelector = $("#userNumber");
    private final SelenideElement registrationButton = $("#submit");
    private final SelenideElement userEmailSelector = $("#userEmail");
    private final SelenideElement subjectSelector = $("#subjectsInput");
    private final SelenideElement hobbySportSelector = $("[for='hobbies-checkbox-1']");
    private final SelenideElement hobbyReadingSelector = $("[for='hobbies-checkbox-2']");
    private final SelenideElement uploadPictureSelector = $("#uploadPicture");
    private final SelenideElement currentAdressSelector = $("#currentAddress");
    private final SelenideElement StateSelector = $("#react-select-3-input");
    private final SelenideElement CitySelector = $("#react-select-4-input");

    private final CalendarComponent calendar = new CalendarComponent();


    public RegistrationPage open() {
        Selenide.open(URL);
        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String firstName) {
        firstNameSelector.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameSelector.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailSelector.setValue(userEmail);
        return this;
    }


    public RegistrationPage setGenderSelector(String gender) {
        genderSelector.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setMobileSelector(String mobileNumber) {
        mobileSelector.setValue(mobileNumber);
        return this;
    }

    public RegistrationPage setDataOfBirth(String day, String month, String year) {
        calendar.setDateOfBirth(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectSelector.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        if("Sports".equals(hobby)) {
            hobbySportSelector.click();
        } else if("Reading".equals(hobby)) {
            hobbyReadingSelector.click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureSelector.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setCurrentAddress(String address) {
        currentAdressSelector.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        StateSelector.setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage setCity(String city) {
        CitySelector.setValue(city).pressEnter();
        return this;
    }


    public RegistrationPage register() {
        registrationButton.click();
        return this;
    }

}

