package pcfront.wonder;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class freshTest {
	  private WebDriver driver;
	  private String screenpath = "C:\\Lee\\PC_auto\\screenshot\\";
	  pcfront.main.urlpath geturl = new pcfront.main.urlpath();
	  
		@Before
		  public void setUp() throws Exception {
		    // chrome 드라이버 위치 지정
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
		    DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		    capabilities.setCapability("marionette", true);
		    driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		    System.out.println("테스트 시작");
			driver.get(geturl.home);
			driver.findElement(By.className("ico_close")).click();        
			Thread.sleep(3000);	 
		}
		public void takeScreenshotofpage(WebDriver driver, String filePath) throws IOException{
			   File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			    BufferedImage srcImage = ImageIO.read(srcFile);
			    ImageIO.write(srcImage, "png", new File(filePath));
		}
		public String getDateTimeStamp(){
			return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
		}
		
		
		@Test
		 public void Wonder_fresh() throws Exception {
			driver.get("http://wemakeprice.com/main/104000");
			List<WebElement> rb = driver.findElements(By.xpath("//div[2]/div/ul/li/a/img"));
			List<WebElement> rb1 = driver.findElements(By.xpath("//div[3]/ul/li/a/img"));
			
			// 상단 작은배너 체크
			if (rb.size() > 0){  
			int rbc = rb.size();
			System.out.println("노출 배너 카운트:"+rbc);
			int i = 0;
			for(int a = 0; a<1; a++){
				System.out.println(a + "번째 싸이클 체크");
				while(i < rbc){
					i++;
					driver.findElement(By.xpath("//div[2]/div/ul/li[" + i + "]/a/img")).click();
					Thread.sleep(3000);
					//404 체크
			        URL url = new URL(driver.getCurrentUrl());
			        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			        connection.setRequestMethod("GET");
			        connection.connect();
			 
			        int code = connection.getResponseCode();
			        Assert.assertEquals(200, code);
			        // 404면 캡처
					if (driver.getCurrentUrl().contains("404"))
					{
						takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + Thread.currentThread().getStackTrace()[1].getMethodName() + ".png");
						}
				driver.navigate().back();
			}
			 i = 0;
			driver.navigate().refresh();
			}
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "에 배너가 없습니다.");
			}
			
			 //하단 배너 체크
			if (rb1.size() > 0){
				int rbc1 = rb1.size();
				System.out.println("하단배너 카운트:"+rbc1);
				int i = 0;
				while(i < rbc1){
					i++;
					driver.findElement(By.xpath("//div[3]/ul/li[" + i + "]/a/img")).click();
					Thread.sleep(3000);
					//404 체크
			        URL url = new URL(driver.getCurrentUrl());
			        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			        connection.setRequestMethod("GET");
			        connection.connect();
			 
			        int code = connection.getResponseCode();
			        Assert.assertEquals(200, code);
			        // 404면 캡처
					if (driver.getCurrentUrl().contains("404"))
					{
						takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + Thread.currentThread().getStackTrace()[1].getMethodName() + ".png");
						}
				driver.navigate().back();
			}
			 i = 0;
			driver.navigate().refresh();
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "에 배너가 없습니다.");
				
			}
		}
		
		
		@After
		public void tearDown() throws Exception {
	        // Check the title of the page
	        System.out.println(getClass().getName() + "종료");
	        driver.close();
		}

	}

