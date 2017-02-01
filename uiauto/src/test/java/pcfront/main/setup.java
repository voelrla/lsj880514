package pcfront.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class setup {
	public static WebDriver driver;
	public static String screenpath = "C:\\Lee\\PC_auto\\screenshot\\";

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Lee\\PC_auto\\chrome\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("테스트 시작");
		driver.get(urlpath.home);
		driver.findElement(By.className("ico_close")).click();
		Thread.sleep(3000);
	}

	@After
	public void tearDown() throws Exception {
		// Check the title of the page
		System.out.println("테스트 종료");
		driver.close();
	}

	// 캡처 메소드 추가
	public static void takeScreenshotofpage(WebDriver driver, String filePath) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage srcImage = ImageIO.read(srcFile);
		ImageIO.write(srcImage, "png", new File(filePath));
	}

	// 캡처사진 명 설정
	public static String getDateTimeStamp() {
		// creates a date time stamp that is Windows OS filename compatible
		return new SimpleDateFormat("MMM dd HH.mm.ss").format(Calendar.getInstance().getTime());
	}

	public static void Failcheck() throws Exception {
		URL url = new URL(driver.getCurrentUrl());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int code = connection.getResponseCode();
		if (driver.getCurrentUrl().contains("404")) {
			takeScreenshotofpage(driver, screenpath + getDateTimeStamp() + "_Failcase." + ".png");
		}
//		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(200, code);
		driver.navigate().back();
	}
	}

