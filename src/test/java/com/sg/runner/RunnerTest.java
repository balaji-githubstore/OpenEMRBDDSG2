package com.sg.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(		
		features = {"src/test/resources/Feature/Login.feature"}		
		,glue = {"com.sg.steps"}
		,monochrome = true
	    ,publish = false
	    ,plugin = {"html:target/index.html"}
//		,dryRun = true
		,tags = "@invalid" //and or not // not @invalid or @valid
		)

@RunWith(Cucumber.class)
public class RunnerTest {

}
