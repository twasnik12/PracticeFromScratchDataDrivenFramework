package com.PS.commons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//  BaseClass is used to load the config file and Initialize
	//  WebDriver
	public static Properties prop;
	public static WebDriver driver;

	@BeforeTest
	public void loadConfig() {
		try {
			prop=new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\Tathagat\\eclipse-workspace\\PracticeFromScratch\\src\\main\\java\\com\\PS\\properties\\config.properties" );
			prop.load(f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//Give the details line number and class name where the exception occurred
		}
	}

	public static void launchApp(String	 browserName) {
		//String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		// Maximize the screen
		driver.manage().window().maximize();
		// Delete all the cookies
		driver.manage().deleteAllCookies();
		//implicit wait new syntax
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Launching the URL	
		driver.get(prop.getProperty("url"));//will wait for still web page open
	}

}


