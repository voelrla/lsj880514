package pcfront.uiauto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class setup {
	static WebDriver driver;
    static String baseUrl;
	public void setUp() throws Exception {
    // chrome 드라이버 위치 지정
	System.setProperty("webdriver.chrome.driver","C:\\Lee\\PC_auto\\chrome\\chromedriver.exe");
    DesiredCapabilities capabilities=DesiredCapabilities.chrome();
    capabilities.setCapability("marionette", true);
    
    driver = new ChromeDriver();
    baseUrl = "http://wemakeprice.com";
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
    System.out.println("테스트 시작");
	driver.get(baseUrl+"/");
	driver.findElement(By.className("ico_close")).click();        
	Thread.sleep(3000);	  
}	
}
