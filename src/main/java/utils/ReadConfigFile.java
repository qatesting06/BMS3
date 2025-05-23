package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadConfigFile {
	private Properties prop;

	public ReadConfigFile(WebDriver driver) throws IOException {
		prop = new Properties(); // Use the class-level variable
		FileInputStream files = new FileInputStream("configuration/config.properties");
		prop.load(files);
		files.close();
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getURL() {
		return prop.getProperty("baseURL");
	}
}
