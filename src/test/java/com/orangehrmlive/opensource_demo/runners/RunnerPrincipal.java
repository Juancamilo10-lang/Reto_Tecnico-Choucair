package com.orangehrmlive.opensource_demo.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.orangehrmlive.opensource_demo.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerPrincipal {
}
