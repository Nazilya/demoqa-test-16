package qa.demo.elements;

import com.codeborne.selenide.SelenideElement;

public class Button {
    private final String name;
    private final SelenideElement selector;

    public Button(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
   // @Step("Нажать кнопку {this.name}")
    public void click() {
        selector.click();
    }
}
