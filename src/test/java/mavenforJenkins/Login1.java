package mavenforJenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login1 {
	
	static WebDriver driver;
	@Parameters("Browser")
	@Test
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
   @Test
	public static void logi1() {
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.cssSelector("input[name='uid']")).sendKeys("mngr353182");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("urAbYpU");
		driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
		String Expectedhead = "Guru99 Bank Manager HomePage";
		String Actualhead = driver.getTitle();
		Assert.assertEquals(Expectedhead, Actualhead);
		System.out.println("Login Successfull");
	}

}
