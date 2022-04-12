package Steps;

import java.util.List;

import PageObjects.LoginPageObject;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
	
	LoginPageObject LoginPageObject;
	
		
	
	@Step
	
	public void Login_entry(List<List<String>> testentries) throws InterruptedException {
		
		
		LoginPageObject.login_page(testentries);
		
		
		
		
		
	}

}
