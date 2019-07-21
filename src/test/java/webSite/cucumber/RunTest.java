package webSite.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/webSite/features",
        glue="webSite/stepDefinitions" )
public class RunTest {

}
