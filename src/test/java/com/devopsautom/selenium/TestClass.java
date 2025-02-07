package com.devopsautom.selenium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void launchDriver() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setCapability("browserVersion", "100");
		chromeOptions.setCapability("platformName", "Windows");
		System.setProperty("webdriver.chrome.driver","C:\\TestingDevops\\selenium\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver = new RemoteWebDriver(new URL("http://192.168.16.1:4444"), chromeOptions);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	
	@Test
	public void test1() {
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void test2() {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void bQuit(){
		driver.quit();
	}
}
