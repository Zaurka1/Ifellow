package ui.pageObject.pageElems;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskElems {
	public static SelenideElement buttonCreateTask = $x("//a[@id=\"create_link\"]");
	public static SelenideElement mainTheme = $x("//input[@name = \"summary\"]");
	public static SelenideElement iframeText = $x("//body[@id = \"tinymce\"]//child::p[1]");
	public static SelenideElement fixInVersions = $x("//select[@aria-labelledby=\"fixVersions-textarea fixVersions-description\"]//option[contains(text(), \"2.0\")]");
	public static SelenideElement affectedVersions = $x("//select[@aria-labelledby=\"versions-textarea versions-description\"]//option[contains(text(), \"2.0\")]");
	public static SelenideElement buttonAppointMe = $x("//button[text()=\"Назначить меня\"]");
	public static SelenideElement buttonCreate = $x("//input[@type=\"submit\" and @value=\"Создать\"]");
	public static SelenideElement linkMyBug = $x("//a[contains(text(), \"New Bug 01\")]");
	public static SelenideElement buttonMoreStatus = $x("//a[@id=\"opsbar-transitions_more\"]");
	public static SelenideElement buttonStatusDone = $x("//span[text()=\"Выполнено\"]/parent::a");
	public static SelenideElement statusCheck = $x("//span[@id=\"status-val\"]/span");
	public static SelenideElement popup = $x("//a[@class=\"aui-button aui-button-link cancel\"]");
}
