package workingwithdraganddrophandling;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import datePicker.Dateandtime;
import base.DriverSetup;
import base.PropertiesFile;
import Screenshot.ScreenShot;

public class DragandDrop extends DriverSetup {
	public static void main(String[] args) throws InterruptedException, IOException {

		// instantiate driver
		
		WebDriver driver = DriverSetup.search();

		String URL = PropertiesFile.DragandDropURL();
		driver.get(URL);

		// Find the "drag" and "drop" webelements
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		// Create an object of Actions class and pass driver object reference to it's constructor
		
		Actions act = new Actions(driver);

		// Call the dragAndDrop() method of actions class.
		
		act.dragAndDrop(drag, drop);
		act.build().perform();

		// Drag element to destination
		
		act.dragAndDrop(drag, drop).build().perform();

		// Validation of Dropped! message
		
		String textTo = driver
				.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/p"))
				.getText();

		if (textTo.equals("Dropped!")) {
			System.out.println("PASS: File is dropped at the target destination and Dropped! text is displayed");
		}

		else {
			System.out.println("FAIL: File couldn't be dropped at the target destination");
		}
		
		// Take a ScreenShot for Validation 
		
		ScreenShot.captureScreenShot(driver);
		
		// Call for the startingDatePicker method 
		
		Dateandtime.startingDatePicker();
		 

	}
}
