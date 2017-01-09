package pcfront.digital;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import pcfront.main.common;
import pcfront.main.main;

public class digitalmain {
	  private WebDriver driver;
	  //캡처파일 저장소 지정
	  private String screenpath = "C:\\Lee\\PC_auto\\screenshot\\";
	  
		@Before
		  public void setUp() throws Exception {
		    // chrome 드라이버 위치 지정
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
		    DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		    capabilities.setCapability("marionette", true);
		    driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		    System.out.println("테스트 시작");
			driver.get(common.home);
			driver.findElement(By.className("ico_close")).click();        
			Thread.sleep(3000);	 
		}
		public void takeScreenshotofpage(WebDriver driver, String filePath) throws IOException{
		pcfront.main.main.takeScreenshotofpage(driver, filePath);
		}
		public String getDateTimeStamp(){
			return pcfront.main.main.getDateTimeStamp();
		}
		
		@Test
		 public void WonderMainbanner() throws Exception {
			driver.get(common.digital);
			List<WebElement> rb = driver.findElements(By.xpath("//ul[@id='promotion_banner']/li/a/img"));
			int rbc = rb.size();
			System.out.println("노출 배너 카운트:"+rbc);
			int i = 0;
			for(int a = 0; a<1; a++){
				System.out.println(a + "번째 싸이클 체크");
				while(i < rbc){
					i++;
					driver.findElement(By.xpath("//ul[@id='promotion_banner']/li[" + i + "]/a/img")).click();
					Thread.sleep(3000);
					if (driver.getCurrentUrl().contains("404"))
					{
						takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ".png");
					}
				driver.navigate().back();
			}
			 i = 0;
			driver.navigate().refresh();
			}
		}
		
		@After
		public void tearDown() throws Exception {
	        // Check the title of the page
	        System.out.println("fashion Pass");
	        driver.close();
		}

	}

