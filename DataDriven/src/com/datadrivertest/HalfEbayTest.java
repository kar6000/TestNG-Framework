package com.datadrivertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;

public class HalfEbayTest {
	
	public static void main(String args[]) {
			
	//Read data from Excel file	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\ipsik\\eclipse-workspace\\Selenium\\src\\com\\testdata\\eBayTestdata.xlsx");
	
	String firstName = reader.getCellData("RegTestData", "firstname", 2);
	System.out.println(firstName);
	
	String lastName = reader.getCellData("RegTestData", "lastname", 2);
	System.out.println(lastName);
	
	String emailId = reader.getCellData("RegTestData", "emailID", 2);
	System.out.println(emailId);
	
	String passWord = reader.getCellData("RegTestData", "password", 2);
	System.out.println(passWord);	
	
	//Web driver code
	WebDriver driver = new ChromeDriver();
	System.setProperty("webdriver.chromedriver","C:/seleniumRC/Tools/chromedriver.exe");
	driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
	
	driver.findElement(By.id("firstname")).sendKeys(firstName);
	driver.findElement(By.id("lastname")).sendKeys(lastName);
	driver.findElement(By.id("email")).sendKeys(emailId);
	driver.findElement(By.id("PASSWORD")).sendKeys(passWord);
	driver.findElement(By.xpath("//input[@type ='submit' and @value ='Register']")).submit();
	
	}		
	
}
