package datePicker;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import base.DriverSetup;
import base.PropertiesFile;
import Screenshot.ScreenShot;
import workingwithdraganddrophandling.DragandDrop;

public class Dateandtime extends DragandDrop {
	
	public static void startingDatePicker() {
		String URL = PropertiesFile.DateandtimeURL();
	driver.get(URL);
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Date date = new Date();
	
    WebElement dateFormat1 = driver.findElement(By.xpath("//*[@id=\"dateAndTimePickerInput\"]")); 
 
	 dateFormat1.sendKeys(Keys.chord(Keys.CONTROL, "a")); 
	 dateFormat1.sendKeys(Keys.BACK_SPACE); 
	 
	 dateFormat1.sendKeys(change(date)); 
	 driver.findElement(By.xpath("//*[@id=\"dateAndTimePicker\"]/div[2]/div[2]/div/div/div[3]/div[2]/div/ul/li[25]")).click();
	 
	 ScreenShot.captureScreenShot(driver);
	 
	
    try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    
    DriverSetup.closeBrowser();

} 
 
	 public static String change(Date d){ 
		int day=Integer.parseInt(d.toString().substring(8,10)); 
		int n_day=0; 
		String[] months={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}; 
		int month=0; 
		int n_month=0; 
		 
		for(int i=0;i<months.length;i++){ 
			if(d.toString().substring(4,7).equals(months[i])){ 
				month=i+1; 
			} 
		} 
		int year=Integer.parseInt(d.toString().substring(24, 28)); 
		int n_year=0; 
		if(isLeap(d)){ 
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10){ 
				if(day>=1 && day<=30){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(31-day); 
					n_month=month+1; 
					n_year=year; 
				} 
			} 
			else if(month==6 || month==4 || month==9 || month==11){ 
				if(day>=1 && day<=29){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(30-day); 
					n_month=month+1; 
					n_year=year; 
				} 
			} 
			else if(month==2){ 
				if(day>=1 && day<=28){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(29-day); 
					n_month=month+1; 
					n_year=year; 
				} 
			} 
			else{ 
				if(day>=1 && day<=30){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(31-day); 
					n_month=1; 
					n_year=year+1; 
				} 
			} 
		} 
		else{ 
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10){ 
				if(day>=1 && day<=30){ 
					n_day=day+1; 
	 				n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(31-day); 
					n_month=month+1; 
					n_year=year; 
				} 
			} 
			else if(month==6 || month==4 || month==9 || month==11){ 
				if(day>=1 && day<=29){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(30-day); 
					n_month=month+1; 
					n_year=year; 
				} 
			} 
			else if(month==2){ 
				if(day>=1 && day<=27){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(28-day); 
					n_month=month+1; 
					n_year=year; 
				} 
			} 
			else{ 
				if(day>=1 && day<=30){ 
					n_day=day+1; 
					n_month=month; 
					n_year=year; 
				} 
				else{ 
					n_day=1-(31-day); 
					n_month=1; 
					n_year=year+1; 
				} 
			} 
		} 
		if((n_day<10 && n_day>=1)){ 
			if((n_month<10 && n_month>=1)){ 
				return("0"+Integer.toString(n_month)+"/0"+Integer.toString(n_day)+"/"+Integer.toString(n_year)); 
			} 
			else{ 
				return(Integer.toString(n_month)+"/"+"0"+Integer.toString(n_day)+"/"+Integer.toString(n_year)); 
			} 
		} 
		else{ 
			if((n_month<10 && n_month>=1)){ 
				return("0"+Integer.toString(n_month)+"/0"+Integer.toString(n_day)+"/"+Integer.toString(n_year)); 
			} 
			else{ 
				return(Integer.toString(n_month)+"/"+"0"+Integer.toString(n_day)+"/"+Integer.toString(n_year)); 
			} 
		} 
	 } 
	 public static boolean isLeap(Date d){ 
		int year=Integer.parseInt(d.toString().substring(24,28)); 
		if(year%4==0){ 
			if(year%100==0){ 
				if(year%400==0){ 
					return true; 
				} 
				else{ 
					return false; 
				} 
			} 
			else{ 
				return true; 
			} 
		} 
		return false; 
	 } 
	


}