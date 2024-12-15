import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;



public class DemoTestFirstTest {


    @BeforeAll
    static void setUp() {
        //Configuration.browser="firefox";    // для отладки
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.holdBrowserOpen = true;          // для отладки
        Configuration.pageLoadStrategy = "eager";

    }


    @Test
    void firstTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("pochta@gmail.com").pressEnter();
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9998887766");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1980");
        $$(".react-datepicker__day").findBy(text("1")).click();
        $("#subjectsInput").setValue("any value").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFromClasspath("капча.jpg");
        $("#currentAddress").setValue("Moscow, Kremlin");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

        //проверка значений
        $(".table-responsive").shouldHave(text("Ivan"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("pochta@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9998887766"));
        $(".table-responsive").shouldHave(text("11 February,1980"));
        $(".table-responsive").shouldHave(text("any value"));
        $(".table-responsive").shouldHave(text("Reading, Sports"));
        $(".table-responsive").shouldHave(text("капча.jpg"));
        $(".table-responsive").shouldHave(text("Moscow, Kremlin"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));

    }
}
