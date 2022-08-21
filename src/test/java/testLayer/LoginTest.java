package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pomPackage.POMLogin;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	POMLogin log;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiate();
	//	screenshots("Login");
		log = new POMLogin();
	}
	
	@Test(priority=1)
	public void Title() throws InterruptedException {
		String title = log.verify();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
		Thread.sleep(1000);
		screenshots("TC_1");
	}
	
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
	
	@Test(priority=2, dataProvider="Details")
	public void Login(String name, String password) throws InterruptedException {
		log.typeusername(name);
		log.typepassword(password);
	//	log.clickbtn();
		Thread.sleep(1000);
		screenshots("TC_2");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
