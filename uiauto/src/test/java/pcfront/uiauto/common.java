package pcfront.uiauto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class common {
		static WebDriver driver;
		public static String home = "http://www.wemakeprice.com/";
		public static String wonder = "http://www.wemakeprice.com/main/100020";
		public static String fashion = "http://www.wemakeprice.com/main/100010";
		public static String food = "http://www.wemakeprice.com/main/100000";
		public static String digital = "http://www.wemakeprice.com/main/100030";
		public static String tour = "http://www.wemakeprice.com/main/990000";
		public static String service = "http://www.wemakeprice.com/main/9411";
		public static String culture = "http://www.wemakeprice.com/main/980000";
		public static String brand = "http://www.wemakeprice.com/brands";
/*
		public void wmpsetup() throws Exception{
		System.setProperty("webdriver.chrome.driver","C:\\work\\chromeDriver\\chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
	    capabilities.setCapability("marionette", true);
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	    System.out.println("테스트 시작");
		driver.get(common.home);
		driver.findElement(By.className("ico_close")).click();  
		Thread.sleep(3000);
		  }
*/		  
}