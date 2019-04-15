package execucao;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/", plugin = {"json","html:target/cucumber-html-report", "json:target/cucumber-html-report.json"},
        tags = {"@Automacao", "~@Incompleto", "~@Revisao"})
public class Automacao {

}
