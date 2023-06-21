package TestNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.assertEquals;
///<Summmar>
///This is a Login Test Case
///</Summary>

public class LoginTestCase {
	 WebDriver _driver;
	 
	///<Summmar>
	  ///This is method to verify Login with valid data
	  ///</Summary>
	
  @Test (description= "this is to verify Login with valid data")
  @Parameters ({"UserName1", "Password1"}) // copied from testing.xml 
 
  public void LoginWithValidData(String UserName2, String Password2) { //here string can be either UserName1 or UserName2 and same with password
 
  _driver.findElement(By.id("loginLink")).click();
  _driver.findElement(By.id("UserName")).sendKeys(UserName2); //here sendkeys must be same as string
  _driver.findElement(By.id("Password")).sendKeys(Password2);
  _driver.findElement(By.xpath("//input[@value='Log in']")).click();
   assertEquals("Hello Adminn!", _driver.findElement(By.xpath("//a[@title='Manage']")).getText());
  
  
  }
  
  
  ///<Summmar>
  ///This is method to verify Login with INvalid data
  ///</Summary>
 
  @Test (description= "this is to verify Login with Invalid data")
  @Parameters ({"UserName1"}) // ony passing username parametr tht means it only hide
  public void LoginWithInValidData(String UserName1) {
	  _driver.findElement(By.id("loginLink")).click();
	  _driver.findElement(By.id("UserName")).sendKeys("UserName1");
	  _driver.findElement(By.id("Password")).sendKeys("Adminn@1234");
	  _driver.findElement(By.xpath("//input[@value='Log in']")).click();
	   assertNotEquals("Hello Adminn!", _driver.findElement(By.xpath("//div[contains(@class,'text-danger')][contains(.,'Invalid login attempt.')]")).getText());
  
  
  }
  
  ///<Summmar>
  ///This is method to intialise Browser
  ///</Summary>
  
  @BeforeTest
  @Parameters ({"browser"})
  public void InitBrowser(String browser) {
	  if(browser.equals("chrome"))
	  {
		  _driver = new ChromeDriver();
	  }
	  else if (browser.equals("firefox"))
	  {
	  
          _driver= new FirefoxDriver ();
	  }
	  else if (browser.equals("edge"))
	  {
	  
          _driver= new EdgeDriver ();
	  }
 _driver.manage().window().maximize();
 _driver.get("http://eaapp.somee.com/");
 
  
  
  }
  ///<Summmar>
  ///This is method to Close Browser
  ///</Summary>
  @AfterTest
  public void ExitBrowser() {
  
  _driver.close();
  }

}
