package com.pages;

import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class medsolLoginpage
{
  WebDriver driver;
  By email = By.name("email");
  By password = By.name("password");
  By login = By.xpath("//button[text()='Login']");

  public medsolLoginpage(WebDriver driver)
  {
      this.driver = driver;
  }
  public void setUserName(String strUserName)
  {
      driver.findElement(email).sendKeys(strUserName);
  }
  public void setPassword(String strPassword)
  {

      driver.findElement(password).sendKeys(strPassword);
 }
  public void clickLogin()
  {

      driver.findElement(login).click();
  }
 
  public void 	medsLogin(String strUserName,String strPasword)
  {
      this.setUserName(strUserName);
      this.setPassword(strPasword);
      this.clickLogin();        
  }


}
