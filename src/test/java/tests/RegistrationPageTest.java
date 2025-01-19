package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckResultRegistrationPage;

public class RegistrationPageTest extends TestBase{

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final CheckResultRegistrationPage checkResult = new CheckResultRegistrationPage();

    private final static String FIRST_NAME = "Иван";
    private final static String LAST_NAME = "Иванов";
    private final static String USER_EMAIL = "pochta@gmail.com";
    private final static String USER_GENDER = "Male";
    private final static String USER_MOBILE = "1111111111";
    private final static String USER_DAY_BIRTH = "12";
    private final static String USER_MONTH_BIRTH = "February";
    private final static String USER_YEAR_BIRTH = "1985";
    private final static String SUBJECT_OF_STUDY = "Arts";
    private final static String SUBJECT_OF_STUFY_2 = "Maths";
    private final static String PICTURE = "капча.jpg";
    private final static String ADDRESS = "Moscow, Kremlin";
    private final static String STATE = "Haryana";
    private final static String CITY = "Karnal";



    @Test
    void fullDataTest() {
        registrationPage.open()
                .removeBanner()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(USER_EMAIL)
                .setGenderSelector(USER_GENDER)
                .setMobileSelector(USER_MOBILE)
                .setDataOfBirth(USER_DAY_BIRTH, USER_MONTH_BIRTH, USER_YEAR_BIRTH)
                .setSubject(SUBJECT_OF_STUDY)
                .setSubject(SUBJECT_OF_STUFY_2)
                .setSportHobby()
                .setReadingHobby()
                .uploadPicture(PICTURE)
                .setCurrentAddress(ADDRESS)
                .setState(STATE)
                .setCity(CITY)
                .register();

        checkResult.resultCheck("Student Name", FIRST_NAME + " " + LAST_NAME)
                .resultCheck("Student Email", USER_EMAIL)
                .resultCheck("Gender", USER_GENDER)
                .resultCheck("Mobile", USER_MOBILE)
                .resultCheck("Date of Birth", USER_DAY_BIRTH + " " + USER_MONTH_BIRTH + "," + USER_YEAR_BIRTH)
                .resultCheck("Subjects", SUBJECT_OF_STUDY + "," + " " + SUBJECT_OF_STUFY_2)
                .resultCheck("Hobbies", "Sports" + "," + " " + "Reading")
                .resultCheck("Picture", PICTURE)
                .resultCheck("Address", ADDRESS)
                .resultCheck("State and City", STATE + " " + CITY);
    }





    @Test
    void minDataTest() {

        registrationPage.open()
                .removeBanner()
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
    void minDataNegativeTest() {

        registrationPage.open()
                .removeBanner()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenderSelector(USER_GENDER)
                .setMobileSelector("")
                .setDataOfBirth(USER_DAY_BIRTH, USER_MONTH_BIRTH, USER_YEAR_BIRTH)
                .register();

        checkResult.negativeResultCheck();

    }
}

