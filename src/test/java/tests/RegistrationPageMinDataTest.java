package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationPage;

public class RegistrationPageMinDataTest extends TestBase{

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final CheckResultRegistrationPage checkResult = new CheckResultRegistrationPage();

    private final static String FIRST_NAME = "Иван";
    private final static String LAST_NAME = "Иванов";
    private final static String USER_GENDER = "Male";
    private final static String USER_MOBILE = "1111111111";
    private final static String USER_DAY_BIRTH = "12";
    private final static String USER_MONTH_BIRTH = "February";
    private final static String USER_YEAR_BIRTH = "1985";

    @Test
    void regPageMinDataTest() {

        registrationPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenderSelector(USER_GENDER)
                .setMobileSelector(USER_MOBILE)
                .setDataOfBirth(USER_DAY_BIRTH, USER_MONTH_BIRTH, USER_YEAR_BIRTH)
                .register();

        checkResult.resultCheck("Student Name", FIRST_NAME + " " + LAST_NAME)
                .resultCheck("Gender", USER_GENDER)
                .resultCheck("Mobile", USER_MOBILE)
                .resultCheck("Date of Birth", USER_DAY_BIRTH + " " + USER_MONTH_BIRTH + "," + USER_YEAR_BIRTH);
    }

    @Test
    void regPageMinDataNegativeTest() {

        registrationPage.open()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenderSelector(USER_GENDER)
                .setMobileSelector("")
                .setDataOfBirth(USER_DAY_BIRTH, USER_MONTH_BIRTH, USER_YEAR_BIRTH)
                .register();

        checkResult.NegativeResultCheck();

    }
}

