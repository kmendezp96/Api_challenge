package features;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //glue =  "src/test/resources/steps",
        features = "src/test/resources/features/storedInstances.feature")
public class TestsStoredInstances {
}
