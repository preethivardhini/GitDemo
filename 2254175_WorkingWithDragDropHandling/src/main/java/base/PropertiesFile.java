package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesFile {
	public static String URL1;
	public static String URL2;
	
	public static String DragandDropURL() {

		try (InputStream input = 
				new FileInputStream("C:\\Users\\mahen\\javaeclipse\\2254175_WorkingWithDragDropHandling\\test-output\\UrlToOpen.properties")) {
			Properties prop = new Properties();
			// load a properties file prop.load(input);
			// get the property value and print it out
			prop.load(input);
			 URL1 = prop.getProperty("URL1");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return URL1;
	}
	
	public static String DateandtimeURL() {
		
		try (InputStream input = 
				new FileInputStream("C:\\Users\\mahen\\javaeclipse\\2254175_WorkingWithDragDropHandling\\test-output\\UrlToOpen.properties")) {
			Properties prop = new Properties();
			// load a properties file prop.load(input);
			// get the property value and print it out
			prop.load(input);
			URL2 = prop.getProperty("URL2");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return URL2;
	}
}
