package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

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

    private final CalendarComponent calendar = new CalendarComponent();


    public RegistrationPage open() {
        Selenide.open(URL);
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

    public RegistrationPage register() {
        registrationButton.click();
        return this;
    }

}

