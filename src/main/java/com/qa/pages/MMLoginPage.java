package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.crm.qa.pages.HomePage;
import com.qa.base.TestBase;

public class MMLoginPage extends TestBase{
	
	@FindBy(xpath="//a[@id='ch_login_icon']")
	WebElement ClicktoLogin;

	@FindBy(xpath="//input[@type=\"text\" and @id=\"ch_login_email\"]")
	WebElement username;
	
	@FindBy(xpath="//input[@type=\"password\" and @id=\"ch_login_password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[@id=\"ch_login_btn\"]")
	WebElement loginBtn;
	
	
	public MMLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//public String validateLoginPageTitle(){
		//return driver.getTitle();
		
	//}
	
	
	
	public MMHomePage login(String un, String pwd){
		
		
		ClicktoLogin.click();
		
		//System.out.println("user name"+ un + "password " + pwd);
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		
		loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		    	
		    
		
		return new MMHomePage();
	}
	
	
	
}
