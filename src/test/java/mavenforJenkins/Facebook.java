package mavenforJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	static WebDriver driver;
	@Parameters("Browser")
	@Test(priority=1)
	public static void launch(String Browsername) {
		
		System.out.println("The browser name is :"+ Browsername);
		if(Browsername.contains("chrome"))
		{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		}
		else if(Browsername.contains("mozilla"))
		{
		WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@Test(priority=2)
	public static void Login()
	{
		driver.get("https://www.amazon.in/");
		String actual="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String expected= driver.getTitle();
		Assert.assertEquals(actual, expected);
		System.out.print("Welcome to home page");
	}

}
