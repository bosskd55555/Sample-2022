package PageObjects;

import java.util.List;

import Utilities.DefaultPageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPageObject extends DefaultPageObject{
	
	@FindBy(xpath = "//*[@id='user-name']")
	private WebElementFacade username_ele;
	
	
	@FindBy(xpath = "//*[@id='password']")
	private WebElementFacade password_ele;
	
	
	@FindBy(xpath = "//*[@id='login-button']")
	private WebElementFacade Login_button;
	
	
	public void login_page(List<List<String>> testentry)
	{
		
		String username=testentry.get(1).get(0);
		String password=testentry.get(1).get(1);
		
		username_ele.sendKeys(username);
		password_ele.sendKeys(password);
		
		Login_button.click();
		
	}
	
	
	
	

}
