package pcfront.uiauto;


import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pcfront.uiauto.main;

public class wonder {
	  private WebDriver driver;
	  //캡처파일 저장소 지정
	  private String screenpath = "C:\\Lee\\PC_auto\\screenshot\\";
	  public TestName name = new TestName();
	  private static main main = new main();
	  
	  
		@Before
		  public void setUp() throws Exception {
			main.setUp();
		}
		public void takeScreenshotofpage(WebDriver driver, String filePath) throws IOException{
		pcfront.uiauto.main.takeScreenshotofpage(driver, filePath);
		}
		public String getDateTimeStamp(){
			return pcfront.uiauto.main.getDateTimeStamp();
		}
		
		@Test
		 public void MainRightbanner() throws Exception {
			
			driver.get("http://www.wemakeprice.com/main/100020/");
			//우측배너 갯수 체크
			List<WebElement> rb = driver.findElements(By.xpath("//ul[@id='promotion_banner']/li/a/img"));
			int rbc = rb.size();
			System.out.println(rbc);
			int i = 0;
			while(i < rbc){
				i++;
				driver.findElement(By.xpath("//ul[@id='promotion_banner']/li[" + i + "]/a/img")).click();
				Thread.sleep(3000);
			if (driver.getCurrentUrl().contains("404"))
				{
				takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + name.getMethodName() + ".png");
			}
				driver.navigate().back();
			}
		}
		
		@After
		public void tearDown() throws Exception {
	        // Check the title of the page
	        System.out.println("Wonder Pass");
	        driver.close();
		}

	}

