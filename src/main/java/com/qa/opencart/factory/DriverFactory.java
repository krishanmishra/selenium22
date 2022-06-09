package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private WebDriver driver;
	Properties prop;

	/*
	 * This method is used to initialize the webdriver on the basis of given browser
	 * name
	 * 
	 * @param browserName
	 * 
	 * @return driver
	 * 
	 */

	//public WebDriver init_driver(String browserName) {
	public WebDriver init_driver(Properties prop) {
		
		String browserName=prop.getProperty("browser").trim();
		
		System.out.println("browser name is : " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		} else {
			System.out.println("Please pass the right browser : " + browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	/*
	 *This method is used to initialize the properties 
	 * 
	 */

	public Properties init_prop() {
		try {
			FileInputStream ip = new FileInputStream(".//src//test//resources//config//config.properties");
			prop = new Properties();
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
