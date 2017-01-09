package pcfront.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

	public class main {
		  private WebDriver driver;
		  private String screenpath = "C:\\Lee\\PC_auto\\screenshot\\";
		  
		@Before
		  public void setUp() throws Exception{
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
		// 캡처 메소드 추가
		public static void takeScreenshotofpage(WebDriver driver, String filePath) throws IOException{
			   File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    BufferedImage srcImage = ImageIO.read(srcFile);
			    ImageIO.write(srcImage, "png", new File(filePath));	
		}
		//캡처사진 명 설정
		public static String getDateTimeStamp()
		{
		    // creates a date time stamp that is Windows OS filename compatible
		    return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
		}
		
		@Test
		 public void MainRightbanner() throws Exception {
			System.out.println("우측 배너");

			//우측배너 갯수 체크
			List<WebElement> rb = driver.findElements(By.xpath("//ul[@id='right_top_event_banner']/li/a/img"));
			int rbc = rb.size();
			
			int i = 0;
			while(i < rbc){
				i++;
				driver.findElement(By.xpath("//ul[@id='right_top_event_banner']/li[" + i + "]/a/img")).click();
				Thread.sleep(3000);
			if (driver.getCurrentUrl().contains("404"))
				{
				takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + getClass().getName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + ".png");
			}
				driver.navigate().back();
			}
		}
			
		@Test
		 public void MainTodaybanner() throws Exception {			
			System.out.println("오늘의 혜택");
			List<WebElement> tb = driver.findElements(By.xpath("//ul[@id='today_deal_banner']/li/a/img"));
			int tbc = tb.size();
			System.out.println("오늘의 혜택 수 :"  + tbc);
			
			int i = 0;
			while(i < tbc){
				i++;
				driver.findElement(By.xpath("//ul[@id='today_deal_banner']/li[" + i + "]/a/img")).click();
				Thread.sleep(3000);
				if (driver.getCurrentUrl().contains("404"))
				{
				takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + ".png");
			}
				driver.navigate().back();
			}
		}

		@After
		public void tearDown() throws Exception {
	        // Check the title of the page
	        System.out.println("Main Pass");
	        driver.close();
		}

	}

