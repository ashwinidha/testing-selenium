package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.TestUtil;
//import com.qa.util.sheet;
import com.qa.base.TestBase;
import com.qa.pages.MMHomePage;
import com.qa.pages.MMHotelPage;
import com.qa.pages.MMLoginPage;

public class MMHotelPageTest extends TestBase {

	MMHomePage homepage;
	MMLoginPage loginpage;
	MMHotelPage hotelpage;
	TestUtil testutil;
	String sheetName = "HotelSearch";
	
	public MMHotelPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		Initialization();
		homepage = new MMHomePage();
		loginpage= new MMLoginPage();
		hotelpage = new MMHotelPage();
		testutil= new TestUtil();
		System.out.println("i am here");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
			}
	
	@DataProvider
	public Object[][] getTestDatamm(){
		System.out.println("at data provider");
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	/*@Test(priority=1)// dataProvider="getTestDatamm")
	public void searchhoteltest() 
	{
		homepage.ClicktoHotel();
		//for location
		hotelpage.SelectLocation("mumbai");
		//for checkin
			    
		hotelpage.checkinDate("2018", "NOVEMBER", "10" );
		
		//for checkout 
		hotelpage.checkoutDate("2018", "DECEMBER", "15");
	    
		//booking room
		hotelpage.roomselect("ROOM 1",2,1);
	
		
	hotelpage.Search();
	}*/

	@Test(priority=1,dataProvider="getTestDatamm")
	public void searchhoteltest(String place,  String yearcheckin, String monthcheckin, String daycheckin) 
	{
		
		System.out.println("reached in searchhotel" + place );
		
		char chartrim='.';
		
		
		homepage.ClicktoHotel();
		//for location
		hotelpage.SelectLocation(place);
		//for checkin
		
		//result.substring(0, result.indexOf('\n'));
		String yrcheckin= yearcheckin.substring(0,yearcheckin.indexOf(chartrim));
		
		
		String dycheckin= daycheckin.substring(0,daycheckin.indexOf(chartrim));
		
		
		
		
	
		
		
			    
		hotelpage.checkinDate(yrcheckin, monthcheckin,dycheckin);
		
		//for checkout 
	//	hotelpage.checkoutDate(yearcheckout, monthcheckout, daycheckout);
	    
		//booking room
		//hotelpage.roomselect(roomselected,adultcount,childcount);
	
		
	//hotelpage.Search();
	}

	
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}	*/

}

