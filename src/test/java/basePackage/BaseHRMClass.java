package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import timeutils.TimeUtils;

public class BaseHRMClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;

	//Step 1- We will create constructor of BaseHRMClass,
	//in which we will basically load the config.properties file to our class variable named as "file" 
	public BaseHRMClass() {

		try {
			FileInputStream file = new FileInputStream(
					"C:\\Users\\kashy\\eclipse-workspace\\HRManagement\\src\\test\\java\\environmentVariables\\config.properties");
			prop.load(file);
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException a) {
			a.printStackTrace();
		}
	}

	//Step 2- We will create method in which we will write all the common code.
	//We will get all the properties that are subjected to change in future from config.properties file
	public static void initiate() {

		String browsername = prop.getProperty("browser");

		if (browsername.equals("Chrome")) {
			System.getProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("FireFox")) {
			System.getProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void screenshots(String Filename) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\kashy\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshots\\Screenshots"+ Filename +".jpg"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
