package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

    private final SelenideElement resultTable = $(".table-responsive"),
            resultTitle = $("#example-modal-sizes-title-lg");


    public <ResultTableEnums> ResultTableComponent checkTable(ResultTableEnums key, String value) {
        System.out.println(key + " " + value);
        resultTable.$(byText(key.toString())).parent()
                .shouldHave(text(value));
        return this;
    }

    public ResultTableComponent checkTitle() {
        resultTitle.shouldHave(exactText("Thanks for submitting the form"));
        return this;
    }
    public ResultTableComponent checkTitleMissing() {
        resultTitle.shouldNotBe(visible);
        return this;
    }
}
