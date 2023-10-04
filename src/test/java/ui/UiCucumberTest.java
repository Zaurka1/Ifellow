package ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"ui/pageObject/pageSteps", "ui/hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class UiCucumberTest {
}
