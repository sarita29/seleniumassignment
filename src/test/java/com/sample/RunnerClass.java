package com.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="feature/BookTicket.feature",glue = {"com/sample/stepdefs"})
public class RunnerClass extends AbstractTestNGCucumberTests {

}
