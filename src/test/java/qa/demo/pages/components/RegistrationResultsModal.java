package qa.demo.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    private SelenideElement
            modalDialog = $(".modal-dialog"),
            modalDialogTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive");

    public void verifyModalAppears() {
        modalDialog.should(appear);
        modalDialogTitle.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkTable(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
    }
}
