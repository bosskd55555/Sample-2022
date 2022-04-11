package Runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


	
	
	@RunWith(CucumberWithSerenity.class)
	@CucumberOptions(plugin= {"pretty","html:target/cucumber-reports","junit:junit_xml/cucumber.xml"},
	features=".\\src\\test\\resources\\Features\\Test\\Test_new.feature",
			//"src/test/resources/Features"
			//features=".\\src\\test\\resources\\Features\\Admin_Application.feature",
	//tags = {"@smoketest16"},
	
			
	glue= {"StepDefinitions"},
	dryRun=false,
	monochrome=true
	)
	
	//tags = {"@@smoketest12"}
	

	
			
	
	public class TestRunner {
	
		
		
	}


