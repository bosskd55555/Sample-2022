package StepDefinitions;

import cucumber.api.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

import java.sql.Driver;

import Steps.LoginSteps;

public class LoginBDD extends PageObject{

	@Steps
	
	LoginSteps LoginSteps;	
	
	@Given(": sample test url navigation")
	public void sample_test_url_navigation()  {
		
		
		getDriver().get("https://www.saucedemo.com/");
		
		
	}

}
