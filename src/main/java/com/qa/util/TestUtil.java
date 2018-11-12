package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	
	
	public static String TESTDATA_SHEET_PATH = "C:/Users/Ashwini/eclipse-workspace/makemytrip/src/main/java"
			+ "/com/qa/testdata/HotelSearch.xlsx";
	
	static Workbook book;
	static Sheet sheet;
		
	
	public static Object[][] getTestData(String sheetName) {
		System.out.println("reached in testutil" + sheetName);
		FileInputStream file = null;
		try {
			System.out.println("reached in testutil");
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	}
	

	
	
	
	///////
	
	
	
public void finddate(String day,String beforexpath,String Afterpath)//,WebElement Month, WebElement Year, String mon, String yr)
	  {
		 
		/*Select select = new Select(driver.findElement(By.xpath("Month")));
		select.selectByVisibleText(mon);
		
		Select select1 = new Select(driver.findElement(By.xpath("Year")));
		select1.selectByVisibleText(yr);*/
		
			
		final int totalweekdays =7;

		boolean flag = false;
		String dayVal= null;


		for(int rownum=1;rownum<=6;rownum ++)
		{
		  for (int colnum= 1;colnum<=totalweekdays ;colnum++)
		{
		try{
		dayVal= driver.findElement(By.xpath(beforexpath+rownum+Afterpath+colnum+"]")).getText();
		}catch(NoSuchElementException e)
		{
		System.out.println("please enter correct date value");
		flag=true;
		break;
		}
		if(dayVal.equals(day))
		{
		driver.findElement(By.xpath(beforexpath+rownum+Afterpath+colnum+"]")).click();
		flag=true;
		break;
		}
		}

		if(flag)
		{break;}

		}


	  }

			
public void SelectDateFromDatePicker(String year, String month, String day,String xval, int i)
{
	String currentYear= null;
	 // Retrieving current year value
	//MMHotelPage hotelpage= new MMHotelPage();
	
	//WebDriverWait wait = new WebDriverWait(driver, 30);
    //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year']"))));
    
	
     currentYear= driver.findElement(By.xpath("//div[@class='"+xval+"']//div//div//div//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year']")).getText();
     

    //System.out.println("curr year " + currentYear);
		// Click on Next arrow till we get desired year
		if(!currentYear.equals(year))
		{
			do{
				driver.findElement(By.xpath("(//div[@class='"+xval+"']//div//div[@class='ui-datepicker-group ui-datepicker-group-last']//div//a[@title='Next']//span[text()='Next'])["+i+"]")).click();
				//div[@class='dateFilter hasDatepicker']//div//div[@class='ui-datepicker-group ui-datepicker-group-last']//div//a[@title='Next']//span[text()='Next']
				
				//div[@class='dateFilterReturn hasDatepicker']//div//div//div//span[text()='Next']
			}while(!driver.findElement(By.xpath("//div[@class='"+xval+"']//div//div//div//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year']")).getText().equals(year));
			
		}
		
		// Select desired month after selecting desired year
		
		String currentMonth= driver.findElement(By.xpath("(//div[@class='"+xval+"']//div//div//div//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])["+i+"]")).getText();
		//System.out.println("curr mnth " + currentMonth);
		if(!currentMonth.equalsIgnoreCase(month))
		{
			do{
				driver.findElement(By.xpath("(//div[@class='"+xval+"']//div//div[@class='ui-datepicker-group ui-datepicker-group-last']//div//a[@title='Next']//span[text()='Next'])["+i+"]")).click();
			}while(!driver.findElement(By.xpath("(//div[@class='"+xval+"']//div//div//div//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])["+i+"]")).getText().trim().equalsIgnoreCase(month));
			
		}
		
		
		//get java month number for desired month
		
		int javaMonthInt = 0;
		try {
			javaMonthInt = TestUtil.getMonthJavaInt(month);
			System.out.println("java mnth"+javaMonthInt);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Find dates of desired month only
		
		
		List<WebElement> allDateOfDesiredMonth= driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//table/tbody[1]//td[(@class=' ui-state-range ui-state-maxDate' or @class=' ui-state-range'  or  @class=' ui-datepicker-days-cell-over ui-state-range ui-state-minDate ui-datepicker-current-day ui-datepicker-today' or @class=' 'or @class=' ui-datepicker-week-end ' ) and @data-month='"+javaMonthInt+"']"));
		
		System.out.println("list of days in selected month" +  allDateOfDesiredMonth);
		for(WebElement d:allDateOfDesiredMonth )
		{
			
			if(d.getText().trim().equals(day))
			{
				d.click();
				break;
			}
		}
		
			
}

//Code to get java month number
	public static int getMonthJavaInt(String monthName) throws java.text.ParseException
	{

		Date date = new SimpleDateFormat("MMMM").parse(monthName);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println("value of month" + cal.get(Calendar.MONTH));
		return cal.get(Calendar.MONTH);
		
	}

}
