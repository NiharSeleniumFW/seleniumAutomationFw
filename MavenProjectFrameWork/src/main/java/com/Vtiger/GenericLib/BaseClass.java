package com.Vtiger.GenericLib;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Vtiger.GenericLib.FileLib;


	public class BaseClass {
		public static WebDriver driver;
		public FileLib flib = new FileLib();
		@BeforeClass
		public void lunchBrowser() throws Throwable  {
			String Browser = flib.getPropertyData("Browser");
			if (Browser.equals("chrome")){
				driver = new ChromeDriver();
				}
			else if(Browser.equals("foerfox")) {
				driver = new FirefoxDriver();
			}
			else if (Browser.equals("ie")) {
				driver = new InternetExplorerDriver();
			}
			else {
				driver = new FirefoxDriver();
			}
		}
		@BeforeMethod
		public void loginToApplication() throws Throwable {
			System.out.println("Login to the application");
			//read url,username password from property file
			String url = flib.getPropertyData("Url");
			String USERNAME = flib.getPropertyData("Username"); 
			String PASSWORD = flib.getPropertyData("Password");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			int count=0;
			while(count<=2) {
				try {
					driver.get(url);
					break;
					}
				catch(Exception e) {
			}
			}
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(By.name("user_name")));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			}
		@AfterMethod
		public void Applicationlogout() throws Throwable {
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//span[text()=' Adminstrator']/../../td/img[@src='themes/softed/images/user.PNG']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//[text()='Sign Out']")).click();
		}

		@AfterClass
		public void closedriver() {
			driver.quit();
		}
		}
}
