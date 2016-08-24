package com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class composeMail {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup(){
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/Chrome2.23/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/intl/en/mail/help/about.html");
	}
	
	@Test
	public void loginGmail() throws InterruptedException{
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		driver.findElement(By.id("Email")).sendKeys("chiranjeeviaggarwal");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("govindagovinda");
		driver.findElement(By.id("signIn")).click();
		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//textarea[@aria-label='To']")).sendKeys("shubham.mathur@gspann.com");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Automated Mail");
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Thank u for Monsoon Selenium Training !!!!");
		driver.findElement(By.xpath("//div[text()='Send']")).sendKeys("Automated Mail");
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}
}
