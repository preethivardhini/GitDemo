package base;

import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {
	public static WebDriver driver;
	public static Properties prop;
	public static int flag = 1;
	
	public static WebDriver search() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select Browser choice:- ");
		System.out.println("1) Enter 1 for Google Chrome\n" + "2) Enter 2 for MS Edge\n" + "3)Enter 3 for Firefox\n");

		int ch = sc.nextInt();

		if (ch == 1) {
			String exePath = ("C:\\Users\\mahen\\OneDrive\\Desktop\\drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
		}

		else if (ch == 2) {
			String exePath = ("C:\\Users\\mahen\\OneDrive\\Desktop\\drivers\\msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", exePath);
			driver = new EdgeDriver();
		}
		else if (ch == 3) {
			String exePath = ("C:\\Users\\mahen\\OneDrive\\Desktop\\drivers\\geckodriver.exe");
			System.setProperty("webdriver.firefox.driver", exePath);
			driver = new FirefoxDriver();
		}
		

		else {
			System.out.println("Wrong Input Entered ");
		}

		driver.manage().window().maximize();
		driver.get("https://demoqa.com/droppable");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.manage().deleteAllCookies();

		return driver;

	}


	public static void closeBrowser() {
		driver.close();
	}
	
}
