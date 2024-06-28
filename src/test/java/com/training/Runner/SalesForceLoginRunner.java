package com.training.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( features = "src/test/resources/Features/SalesForceLogin.feature",
				  glue = "com.training.StepDefination",
				  monochrome = true,
				  dryRun = false,
				  plugin = {"pretty",
						  "json:target/cucumber-reports/cucumber.json",
						  "html:target/cucumber-reports/cucumber.html"
						  })

public class SalesForceLoginRunner extends AbstractTestNGCucumberTests{

}
