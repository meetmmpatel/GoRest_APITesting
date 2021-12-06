package com.jsonplaceholder.api;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources", glue = "{src/test/java/com/jsonplaceholder/api/stepDefinition}")
public class TestRunner {

}


