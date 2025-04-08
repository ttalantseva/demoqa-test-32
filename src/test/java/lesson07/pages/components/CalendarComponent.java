package lesson07.pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement calendarComponent = $("#dateOfBirthInput");
    private final SelenideElement monthSelector = $(".react-datepicker__month-select");
    private final SelenideElement yearSelector = $(".react-datepicker__year-select");
    private final ElementsCollection dayOfBirth = $$(".react-datepicker__day");


    public void setDateOfBirth (String day, String month, String year) {
        calendarComponent.click();
        monthSelector.selectOption(month);
        yearSelector.selectOption(year);
        dayOfBirth.findBy(text(day)).click();
    }
}
