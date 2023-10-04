package ui.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class WebHooks {
    @Before
    public void setUp() {
        Configuration.startMaximized = true;
        Configuration.headless = false;
    }

    @After
    public void tearUp() {
        Selenide.closeWindow();
    }
}