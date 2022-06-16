package com.yasisv.payroll.feature;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		      features = {"src/test/java/EmployeeFeature"},
              glue = {"."}
		      )

public class CucumberIntegrationTest {
}