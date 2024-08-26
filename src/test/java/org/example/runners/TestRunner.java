package org.example.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
    @CucumberOptions(
            features = "C:\\Users\\ASUS\\IdeaProjects\\E2E\\src\\test\\java\\org\\example\\feactures",
            glue = "org.example.steps",
            plugin = {"pretty", "html:target/cucumber-reports"}
    )
    public class TestRunner {
    }

