package utils;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
    public static WebDriver driver;

    public static void getDriver(String url) throws Exception {
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
       
    }

	@AfterClass
	public static void closeBrowser() {
		driver.quit();
	}
}
