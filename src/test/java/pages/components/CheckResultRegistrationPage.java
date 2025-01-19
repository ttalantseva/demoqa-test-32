package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultRegistrationPage {

    private final SelenideElement tableResults = $(".table-responsive");
    private final SelenideElement userNumberElement = $("#userNumber");



    public CheckResultRegistrationPage resultCheck(String key, String value) {
        tableResults.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }


    public void negativeResultCheck() {
        userNumberElement.shouldHave(Condition.cssValue("border-color", "rgb(220, 53, 69)"));
    }
}


