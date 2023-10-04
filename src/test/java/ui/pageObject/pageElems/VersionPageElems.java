package ui.pageObject.pageElems;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class VersionPageElems {
    public static SelenideElement task = $x("//span[text()='TestSelenium']");
    public static SelenideElement version = $x("//span[text()='TestSelenium']/parent::div/following-sibling::span[contains(text(),'Version')]");
    public static SelenideElement status = $x("(//strong[text()='Статус:']/following::span)[1]/span");

}
