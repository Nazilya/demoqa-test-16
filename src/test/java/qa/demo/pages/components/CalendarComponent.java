package qa.demo.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement

    monthsLocator = $(".react-datepicker__month-select"),
    yearsLocator = $(".react-datepicker__year-select");


    public void setDate(String day, String month, String year) {
        monthsLocator.selectOption(month);
        yearsLocator.selectOption(year);
        $(".react-datepicker__day--0" + day).click();
//        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month").click();

    }
}
