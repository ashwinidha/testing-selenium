package com.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.MMLoginPage;

public class MMLoginTest extends TestBase{

	MMLoginPage loginPage;
	Logger log=Logger.getLogger(MMLoginTest.class);
	
	public MMLoginTest()
	{
		super();
		 System.out.println("hi MMlogin super constructor calling");
		 log.info("In constrctor");
	}
	
	@BeforeMethod
	public void setUp(){
		
		Initialization();
		loginPage = new MMLoginPage();
		log.warn("Intializing methods");
	}
	
	@Test(priority=1)
	public void loginTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
