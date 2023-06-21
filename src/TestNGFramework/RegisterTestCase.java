package TestNGFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class RegisterTestCase {
	
	WebDriver _driver;
	
	///<Summmar>
	  ///This is method to verify Register with valid data
	  ///</Summary>
		
	@Test(description= "this is to verify Register with valid data")
  public void RegisterWithValidData() {
    _driver.findElement(By.id("registerLink")).click();
  	_driver.findElement(By.id("UserName")).sendKeys("Adminnnnn");
  	_driver.findElement(By.id("Password")).sendKeys("Adminnnnn");
  	_driver.findElement(By.id("ConfirmPassword")).sendKeys("Adminnnnn");
  	_driver.findElement(By.id("Email")).sendKeys("hjkhk@gmail.com");
  	_driver.findElement(By.xpath("//input[@value='Register']")).click();
  assertNotNull( _driver.findElement(By.xpath("//a[@title='Manage']")));
	}
	  ///This is method to verify Register with valid data
	  ///</Summary>
	 	

	@Test(description= "this is to verify Register with Blank data")
	  public void RegisterWithBlankdData() {
		 _driver.findElement(By.id("registerLink")).click();
		  	_driver.findElement(By.id("UserName")).sendKeys("");
		  	_driver.findElement(By.id("Password")).sendKeys("");
		  	_driver.findElement(By.id("ConfirmPassword")).sendKeys("");
		  	_driver.findElement(By.id("Email")).sendKeys("");
		  	_driver.findElement(By.xpath("//input[@value='Register']")).click();
		  assertNotNull( _driver.findElement(By.xpath("//div[contains(@class,'text-danger')][contains(.,'The UserName field is required.')]")));
		   }
  ///<Summmar>
  ///This is method to intialise Browser
  ///</Summary>
  
  @BeforeTest
  public void InitBrowser() {
 _driver= new EdgeDriver ();
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
