package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class MMHotelPage extends TestBase{

	
	//for location element
	
	@FindBy (xpath="//input[@id=\"hp-widget__sDest\"]")
	 WebElement placetovisit;
	

	@FindBy (xpath="//li[@class=\"ui-menu-item\"]")
	List<WebElement> list;
	
	@FindBy (xpath= "//span[@class='autoCompleteItem__label']")
	List <WebElement> country;
	//for checkin
	
	@FindBy (xpath="//input[@id=\"hp-widget__chkIn\"]")
	WebElement checkin;
	
	//for checkout
	@FindBy (xpath="//input[@id=\"hp-widget__chkOut\"]")
	WebElement checkout;
	
   //For room selection elements

    @FindBy(xpath="//input[@id=\"hp-widget__paxCounter\"]")
    WebElement rooms;
    
    @FindBy(xpath="//button[@id='js-addGuestRoom'  and contains(text(),'Add Room')]")
    WebElement Addrooms;
    
    @FindBy(xpath="//span[@class='roomCounter']")
    WebElement RoomString;
    //for searching
    
    @FindBy(xpath="//button[@id=\"searchBtn\"]")
    WebElement Searchbutton;
	
	
	TestUtil test = new TestUtil();
	
	

	public MMHotelPage()
	{
		PageFactory.initElements(driver, this);
		 
	}
	
	
public void SelectLocation(String place)
		    {
		    			    	
		    	placetovisit.clear();
		    	placetovisit.click();
		    	
		    	System.out.println("in page method   " + place);
		    	
		    	//Select sel = new Select((WebElement) country);
	    		//sel.selectByVisibleText(place);
	    		
	    		//System.out.println("Value of input string at select is ===>" + sel +"   value of place ==>"+ place);
	    		
		    	
		    	for (int i=0;i<list.size();)
		    	{
		    		
		    		
		    		System.out.println("value of i== " + i);
		    		System.out.println("value of list= " + list.size());
		    		System.out.println("value of list===> " + list.get(i).getText());
		    		
		    		
		    		
		    		if (list.get(i).getText().toUpperCase().contains(place.toUpperCase()))
		    		{
		    			list.get(i).click();
		    			break;
		    			//System.out.println("reached here");
		    			//break;
		    		
		    		}else {i++;}
		    			
		    		
				}
		    	
          
		    }
           	
                   
public void checkinDate(String year, String month, String day)
{
	 checkin.click();
	 String xval1="dateFilter hasDatepicker";
	 test.SelectDateFromDatePicker(year, month, day,xval1,1);
	 
}

public void checkoutDate(String year, String month, String day)
{

	
	 //checkout.click();
	 String xval2="dateFilterReturn hasDatepicker";
     test.SelectDateFromDatePicker(year, month, day,xval2,1);
  
}

public void roomselect(String room, int Adultnumber, int childnumber)
{
	rooms.click();
	
	System.out.println(RoomString.getText());
	
	if (RoomString.getText().equals(room))
	{
		//for adult
		WebElement Adultselection=driver.findElement(By.xpath("//span[contains(text(),'"+room+"')]//parent::p[@id='js-roomOption__title']//following-sibling::div[@id='js-roomOption__details']//descendant::div//descendant::div//descendant::ul[@class='adult_counter']//li[contains(text(),'"+Adultnumber+"')]"));
	   //for child selection
		WebElement Childselection= driver.findElement(By.xpath("//span[contains(text(),'"+room+"')]//parent::p[@id='js-roomOption__title']//following-sibling::div[@id='js-roomOption__details']//descendant::div//descendant::div//descendant::ul[@class='child_counter']//li[contains(text(),'"+childnumber+"')]"));

	Adultselection.click();
	Childselection.click();
	}
	else
	{
		System.out.println("reached here");
		String S1= RoomString.getText();
		String S2= S1.substring(0,4);
		int i=1;
		
		//System.out.println("value of S2" + S2 + "value of s3" + S3);
		
		while(!(S2+" "+i).equalsIgnoreCase(room)) {
	   
			WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(Addrooms));
 		Addrooms.click();
 		i = i+1;
 		
		
		}

		//for adult
		WebElement Adultselection=driver.findElement(By.xpath("//span[contains(text(),'"+room+"')]//parent::p[@id='js-roomOption__title']//following-sibling::div[@id='js-roomOption__details']//descendant::div//descendant::div//descendant::ul[@class='adult_counter']//li[contains(text(),'"+Adultnumber+"')]"));
	   //for child selection
		
		WebElement Childselection= driver.findElement(By.xpath("//span[contains(text(),'"+room+"')]//parent::p[@id='js-roomOption__title']//following-sibling::div[@id='js-roomOption__details']//descendant::div//descendant::div//descendant::ul[@class='child_counter']//li[contains(text(),'"+childnumber+"')]"));

		Adultselection.click();
		Childselection.click();
	
	}	
}
		    
public void Search()
{
	Searchbutton.click();
}


}
