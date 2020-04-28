package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestCase {
	@Test (priority=1,enabled=false)
	public void search() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/ul/li[1]/div/div[2]/div/span")).click();
		//driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3")).click();
		driver.findElement(By.partialLinkText("www.selenium.dev")).click();
		Assert.assertEquals(driver.getTitle(),"SeleniumHQ Browser Automation");	
		driver.quit();
	}
	@Test (priority=2)
	public void register() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://magento.com");
		driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[9]/a/span[1]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"register\"]/span")).click();
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Meenu");
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Karthik");
		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("meenakshi@karthik@gmail.com");
		Select cp= new Select(driver.findElement(By.id("company_type")));
		cp.selectByValue("development");
		Select role= new Select(driver.findElement(By.id("individual_role")));
		//role.selectByValue("business/sales/marketing/merchandising");
		role.selectByIndex(2);
		Select country=new Select(driver.findElement(By.id("country")));
		//country.selectByValue("IN");
		country.selectByVisibleText("India");
	
	    driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("goodmorning");
		driver.findElement(By.id("password-confirmation")).clear();
		driver.findElement(By.id("password-confirmation")).sendKeys("goodmorning");
		if(!driver.findElement(By.id("agree_terms")).isSelected())
			
	     {
			driver.findElement(By.id("agree_terms")).click();
			
				}
	}
		
	}


	


