package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

	protected static WebDriver driver;

	public DriverFactory() {
		initialize();
	}

	public void initialize() {
		if (driver == null)
			createNewDriverInstance();
	}

	private void createNewDriverInstance() {
		System.setProperty("webdriver.chrome.driver", "jars/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void destroyDriver() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		driver = null;
	}
}
