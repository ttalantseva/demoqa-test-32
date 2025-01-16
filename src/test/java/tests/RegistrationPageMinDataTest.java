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
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setGenderSelector("Male")
                .setMobileSelector("1111111111")
                .setDataOfBirth("12", "February", "1985")
                .register();

        checkResult.resultCheck("Student Name", "Иван Иванов")
                .resultCheck("Gender", "Male")
                .resultCheck("Mobile", "1111111111")
                .resultCheck("Date of Birth", "12 February,1985");
    }

    @Test
    void regPageMinDataNegativeTest() {

        registrationPage.open()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setGenderSelector("Male")
                .setMobileSelector("")
                .setDataOfBirth("12", "February", "1985")
                .register();

        checkResult.NegativeResultCheck();

    }
}

