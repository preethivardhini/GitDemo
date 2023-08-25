package Screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {
	public static int flag = 1;

	public static void captureScreenShot(WebDriver driver) {
		try {

			TakesScreenshot capture = (TakesScreenshot) driver;
			File srcFile = capture.getScreenshotAs(OutputType.FILE);
			if (flag == 1) {
				File destFile = new File(("C:\\Users\\mahen\\javaeclipse\\2254175_WorkingWithDragDropHandling\\Screenshot")
						+ "DragandDrop Screenshot.png");
				Files.copy(srcFile, destFile);

			}

			else {
				File destFile = new File(("C:\\Users\\mahen\\javaeclipse\\2254175_WorkingWithDragDropHandling\\Screenshot")
						+ "DateandTime Screenshot.png");
				Files.copy(srcFile, destFile);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		flag++;
	}
}
