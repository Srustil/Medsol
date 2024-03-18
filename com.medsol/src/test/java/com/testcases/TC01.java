package com.testcases;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import com.pages.medsolLoginpage;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TC01 
{
	WebDriver driver;

    medsolLoginpage objLogin;

    @BeforeTest
    public void setup()
    {
        
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://medsolbuffer.in/login");
    }

    

    @Test(priority=0)
    public void test_LoginPage()
    {

	    objLogin = new medsolLoginpage(driver);
	    objLogin.medsLogin("srushtilingaraju@hms.com", "12345678");
	    
    }
}
