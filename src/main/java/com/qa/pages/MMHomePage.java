package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class MMHomePage extends TestBase{
	
@FindBy (xpath="//a[@id=\"ch_logged-in\"]")
WebElement LoggedinUSer;

@FindBy (xpath="//img[@class=\"mmt_header_logo\" and @src=\"//imgak.mmtcdn.com/hcs/assets/img/mmtlogo.png\"]")
WebElement Logo;

@FindBy (xpath="//p[contains(text(),\"estd. 2000. crafted in india\")]")
WebElement Footer;

@FindBy (xpath="//a[contains(text(),'hotels')]")
WebElement HotelLink;


public MMHomePage()
{
	PageFactory.initElements(driver, this);
}

public String Loggedinuser()
{
     String Userinfo = LoggedinUSer.getText();
	 return Userinfo;
	
}

public String Verifytitle()
{
	return driver.getTitle();
	
}

public boolean verifyLogo()
{
	return  Logo.isDisplayed();
}

public String verifyfooter()
{
	return Footer.getText();
	
}


public  void ClicktoHotel()
{
	HotelLink.click();
	//return new MMHotelPage();
}

}
