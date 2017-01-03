package pcfront.main;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class check404 {
	  private WebDriver driver;
	  private String baseUrl;
	  //캡처파일 저장소 지정
	  private String screenpath = "C:\\Lee\\PC_auto\\screenshot\\";
	  public TestName name = new TestName();
		  
	@Before
	  public void setUp() throws Exception {
	    // chrome 드라이버 위치 지정
		System.setProperty("webdriver.chrome.driver","C:\\Lee\\PC_auto\\chrome\\chromedriver.exe");
	    DesiredCapabilities capabilities=DesiredCapabilities.chrome();
	    capabilities.setCapability("marionette", true);
	    
	    driver = new ChromeDriver();
	    baseUrl = "http://test.wemakeprice.com/";
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	    System.out.println("테스트 시작");
		driver.get(baseUrl+"/");
		driver.findElement(By.className("ico_close")).click();        
		Thread.sleep(3000);	  
	}
	
	// 캡처 메소드 추가
	public void takeScreenshotofpage(WebDriver driver, String filePath) throws IOException{
	main.takeScreenshotofpage(driver, filePath);
	}
	//캡처사진 명 설정
	public String getDateTimeStamp()
	{
		return main.getDateTimeStamp();
	}
	
	
	
	@Test
	public void test() throws Exception {
		driver.findElement(By.xpath("//ul[@id='gnb_top_menu']/li[3]/a/span")).click();
		List<WebElement> pb = driver.findElements(By.xpath("//ul[@id='promotion_banner']/li/a/img"));
		int pbc = pb.size();
		int i = 0;
		while(i < pbc){
			i++;
			driver.findElement(By.xpath("//ul[@id='promotion_banner']/li[" + i + "]/a/img")).click();
			Thread.sleep(3000);
		if (driver.getCurrentUrl().contains("404"))
			{
			takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + ".Failcase." + name.getMethodName() + ".png");
		}
			driver.navigate().back();
		}
	}
	
	@After
	public void tearDown() throws Exception {
        System.out.println("Main 테스트 완료");
        driver.close();
	}

}
