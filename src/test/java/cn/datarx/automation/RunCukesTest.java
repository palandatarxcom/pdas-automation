package cn.datarx.automation;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        plugin = {
                "pretty",
                "html:target/pretty",
                "json:target/cucumber.json"
        },
        tags = {}
)
public class RunCukesTest {

}