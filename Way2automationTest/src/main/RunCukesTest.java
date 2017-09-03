package main;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/Features" }
		, monochrome = true
		, plugin = { "pretty",
		"html:target/cucumber-html-report", "json:target/cucumber.json" }
		, tags = "@demo, @login"
		)

public class RunCukesTest {
}
