package assignment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Cricbuzz {
	 
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
			// Grid//Remote Machine
			//I am going to define some capability if this capability is present/matches my real emulator device capability it should run
			//http://appium.io/docs/en/writing-running-appium/caps/
			
			//common capabilities to trest
			DesiredCapabilities cap = new DesiredCapabilities();
	        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Manoj");
	        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        
	        //i am test on web//to add 
	        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	        //chrome driver executable  will not be avaialble  in mobilecapability //android capability
	        cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Selenium_Mobile\\New folder\\chromedriver_win32\\chromedriver.exe"); 
	        
	        //https://drive.google.com/file/d/18Dlnxit2WGPrMFCl9tlkYlzCNyuWjefR/view?usp=sharing       
	        
	        AndroidDriver<AndroidElement> driver= new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);        
	        
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("https://m.cricbuzz.com/");
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        //WebElement ele1 = driver.findElement(MobileBy.id("com.android.chrome:id/menu_button"));
	        //ele1.click();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement ele = driver.findElement(By.xpath("//*[contains(text(),'England clinch series 1-0')]"));
	        js.executeScript("arguments[0].scrollIntoView();", ele);
	        //ele.click();
	}
}
