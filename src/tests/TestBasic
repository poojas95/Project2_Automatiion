package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.BrowserManager;
import pages.PropertiseLoader;

public class TestBasic {
	 public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

	    public static synchronized WebDriver getDriver() {
	        return tdriver.get();
	    }

	    @BeforeMethod
	    public void setup() throws IOException {
	        String url = PropertiesLoader.loadProperty("url");
	        WebDriver driver = BrowserManager.doBrowserSetup();
	        tdriver.set(driver);
	        getDriver().get(url);
	    }

	    @AfterMethod
	    public void tearDown() {
	        getDriver().quit();
	        tdriver.remove();
	    }
	
}
