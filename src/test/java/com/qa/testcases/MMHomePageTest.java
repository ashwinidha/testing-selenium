package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.MMHomePage;
import com.qa.pages.MMLoginPage;

public class MMHomePageTest extends TestBase{

	MMHomePage homepage;
	MMLoginPage loginpage;
	
	public MMHomePageTest()
	{
		super();
		
	}

	@BeforeMethod
	public void Setup()
	{
		Initialization();
		homepage = new MMHomePage();
		loginpage= new MMLoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
 /* 
@Test(priority=1)
public void verifyLoggedinuser()
{
   String ActualUser = homepage.Loggedinuser();
   System.out.println("user details#####" + ActualUser);
   //Assert.assertEquals(ActualUser, "Hey Ashwi..");
}

@Test(priority=2)
public void verifytitle()
{
String Actualtitle=homepage.Verifytitle();
Assert.assertEquals(Actualtitle, "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday");
//System.out.println("tile is " + Actualtitle );
}

@Test(priority=3)
public void LogoImageTest(){
	boolean flag = homepage.verifyLogo();
	Assert.assertTrue(flag);
}

@Test(priority=4)
public void verifyfooter()
{
String Actualfooter=homepage.verifyfooter();
Assert.assertEquals(Actualfooter, "ESTD. 2000. CRAFTED IN INDIA");
}
*/
@Test(priority=1)
public void clicktoHotellink()
{
homepage.ClicktoHotel();
}

@AfterMethod
public void tearDown(){
	driver.quit();
}


}

