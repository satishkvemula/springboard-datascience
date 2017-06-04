import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoOverRouteMaps {

	public static void main(String... args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "/Users/p2723777/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		
		driver.get("file:///Users/p2723777/personal/temp/Weather%20History%20for%20San%20Francisco,%20CA%20_%20Weather%20Underground.htm");

	}

	// public static void main(String... args) throws InterruptedException,
	// IOException {
	//
	// try {
	// // DesiredCapabilities caps = DesiredCapabilities.chrome();
	// // caps.setCapability("platform", "Windows XP");
	// // caps.setCapability("version", "43.0");
	// System.setProperty("webdriver.chrome.driver",
	// "/Users/p2723777/Downloads/chromedriver");
	//
	// ChromeDriver driver = new ChromeDriver();
	// driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.MILLISECONDS);
	//
	//// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/routemap.html");
	// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	// Thread.sleep(1000);
	// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	// Thread.sleep(1000);
	// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	// Thread.sleep(1000);
	// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	// Thread.sleep(1000);
	// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	// Thread.sleep(1000);
	//// driver.get("http://www.google.com");
	//// Thread.sleep(1000);
	//// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	//// Thread.sleep(1000);
	//// driver.get("http://www.google.com");
	//// Thread.sleep(1000);
	//// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	//// Thread.sleep(1000);
	//// driver.get("http://www.google.com");
	//// Thread.sleep(1000);
	//// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	//// Thread.sleep(1000);
	//// driver.get("http://www.google.com");
	//// Thread.sleep(1000);
	//// driver.get("file:///Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.html");
	//// Thread.sleep(1000);
	//// driver.get("http://www.google.com");
	//// Thread.sleep(1000);
	//
	// File scrFile = ((TakesScreenshot)
	// driver).getScreenshotAs(OutputType.FILE);
	//
	// // Now you can do whatever you need to do with it, for example copy
	// // somewhere
	// FileUtils.copyFile(scrFile, new
	// File("/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/timestampMap_size15.png"));
	//
	// driver.quit();
	// } catch(org.openqa.selenium.TimeoutException exc) {
	// System.out.println(exc);
	// }
	// }
}
