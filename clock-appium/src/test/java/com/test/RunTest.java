package com.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.messages.types.Hook;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberTestes.json", "html:target/reports/html"},
        features = "src/test/resources/features",
        tags = "@test",
        glue = {"com.test"}
)

public class RunTest {
    @AfterClass
    public static void closeApp(){
        Hooks.quitDriver();
    }
}
