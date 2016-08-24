package com;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddItemToCart {
	WebDriver driver;


	@BeforeTest
	public void setup(){
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/Chrome2.23/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
				if(browser.equals("firefox")){
		driver = new FirefoxDriver();
				}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/#");
	}

	@Test
	public void addItemToBag() throws InterruptedException{
		int randomSearchListRow;
		int randomJeans;
		int randomSizeJeansValue;
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("jeans");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		int searchListSize = driver.findElements(By.xpath("//div[@class='_2xw3j-']/div[3]/div")).size();
		Random pickRandomSearchListRow = new Random();
		randomSearchListRow = pickRandomSearchListRow.nextInt(searchListSize);
		if(randomSearchListRow == 0){
			randomSearchListRow=randomSearchListRow+33333333;
		}

		int noOfJeans=driver.findElements(By.xpath("//div[@class='_2xw3j-']/div[3]/div["+randomSearchListRow+"]/div")).size();
		Random pickRandomJeans = new Random();
		randomJeans = pickRandomJeans.nextInt(noOfJeans);
		if(randomJeans == 0){
			randomJeans=randomJeans+1;
		}
		driver.findElement(By.xpath("//div[@class='_2xw3j-']/div[3]/div["+randomSearchListRow+"]/div["+randomJeans+"]")).click();

		Random random3 = new Random();
		int jeansSizesCount = driver.findElements(By.xpath("//div[@class='rPoo01']//ul//a")).size();
		randomSizeJeansValue = random3.nextInt(jeansSizesCount);
		if(randomSizeJeansValue == 0){
			randomSizeJeansValue=randomSizeJeansValue+1;
		}

		driver.findElement(By.xpath("//div[@class='rPoo01']//ul/li["+randomSizeJeansValue+"]/a")).click();
		driver.findElement(By.xpath("//button[@class='_3zLR9i _3Plo8Q _19RW-r']")).click();
		driver.findElement(By.xpath("//a[@class='_3NFO0d']")).click();
		driver.findElement(By.xpath("//a[@title='Remove Item']")).click();
	}

	@AfterTest
	public void quit(){
		driver.quit();
	}
}
