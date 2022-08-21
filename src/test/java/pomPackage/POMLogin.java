package pomPackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class POMLogin extends BaseHRMClass {

	//Step 1- Create Object Repository of login page
	@FindBy(id="txtUsername") WebElement Username;	//driver.findElement(By.id("txtUsername"))
	@FindBy(id="txtPassword") WebElement Password;
	@FindBy(id="btnLogin") WebElement Loginbtn;
	
	//Step 2- We will initialize above elements
	public POMLogin() {
		PageFactory.initElements(driver, this);
	}
	
	//Step 3- Create methods for the actions on each element
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn() {
		Loginbtn.click();
	}
	
	public String verify() {
		return driver.getTitle();
	}
}
