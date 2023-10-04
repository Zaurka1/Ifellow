package ui.pageObject.pageElems;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginElems {
    public static SelenideElement inputLogin = $x("//input[@name = \"os_username\"]");
    public static SelenideElement inputPassword = $x("//input[@name = \"os_password\"]");
    public static SelenideElement accessAuth = $x("//a[@title=\"Пользовательский профиль для AT13\"]");
}
