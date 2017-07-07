package cn.datarx;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cn.datarx"
)
public class RunCukesTest { // NOSONAR SonarLint does not know about @RunWith(Cucumber.class)
}
