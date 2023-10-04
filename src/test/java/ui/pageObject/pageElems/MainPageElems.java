package ui.pageObject.pageElems;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageElems {
    public static SelenideElement buttonProjects = $x("//a[@title=\"Просмотр недавних проектов или списка всех проектов\"]");
    public static SelenideElement dropdownMenu = $x("//a[text()=\"Просмотр всех проектов\"]");
    public static SelenideElement buttonTestProject = $x("//a[@data-track-click=\"projects.browse.project\"]");
    public static SelenideElement buttonTasks = $x("//a[@class=\"aui-nav-item \"][1]");
    public static SelenideElement tasksNumber = $x("//div[@class=\"ghx-backlog-header js-marker-backlog-header\"]//parent::div[@class=\"ghx-issue-count\"]");
}
