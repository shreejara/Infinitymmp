package org.iit.workforce.mvn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ScheduleAppointment {
WebDriver driver;
	
	@Test
	public void bookAppointment()
	{
	 
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys("ria1");
		driver.findElement(By.id("password")).sendKeys("Ria12345");
		driver.findElement(By.name("submit")).click();
		String actual = driver.findElement(By.xpath("//h3[normalize-space()='ria1']")).getText().trim();
		String expected="ria1";
		Assert.assertEquals(actual,expected);
		
		driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		
		driver.findElement(By.xpath("//h4[text()='Dr.Shanmugam']/parent::li/div/p[text()='Description:Orthopedic']/ancestor::ul/following-sibling::button")).click();
	}

}

