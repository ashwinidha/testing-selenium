package com.qa.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testingclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
	       Date det = new Date();
	       System.out.println(dateFormat.format(det)); 
	      
	}

}
