package StepDefinitions;

import cucumber.api.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

import java.sql.Driver;
import java.util.List;

import Steps.LoginSteps;

public class LoginBDD extends PageObject{

	@Steps
	
	LoginSteps LoginSteps;	
	
	
	
	@Given("sample test url navigation")
	public void sample_test_url_navigation() {
		getDriver().get("https://www.saucedemo.com/");
		getDriver().manage().window().maximize();
	}

	@Given("Login into the page with username and password")
	public void login_into_the_page_with_username_and_password(List<List<String>> Datatable) throws InterruptedException {
	   
		LoginSteps.Login_entry(Datatable);
		
		Thread.sleep(5000);
	}


}
