package com.ui.runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/ui/featurefiles",
        glue = {"com.ui.stepDefinations"},
        monochrome = true,
        dryRun=false,
        plugin = { "pretty", "html:target/cucumber-reports" },
        strict = true
)

public class Runner_UI {

}