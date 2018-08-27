import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        //glue =  "src/test/resources/steps",
        features = "src/test/resources/features/songsById")
public class TestsById {
}
