package com.pages;

import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Baseclass
{
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	public WebDriver getdriver()
	{
		return driver;
	}

	public void setup() throws IOException 
	{
		if (driver == null) 
		{

			System.out.println("the project path is:" + System.getProperty("user.dir"));

			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//config files//configuration.properties");
			FileReader fr1 = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//config files//locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("testurl"));

		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) 
		{
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("testurl"));

		}
	}

	public void teardown() 
	{

		driver.close();
		System.out.println("tear down succeessful");

	}

}
