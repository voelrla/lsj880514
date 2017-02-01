package pcfront.main;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class mainTest extends setup {
	@Test
	public void MainRightbanner() throws Exception {
		System.out.println("우측 배너");
		// 우측배너 갯수 체크
		List<WebElement> rb = driver.findElements(By.xpath("//ul[@id='right_top_event_banner']/li/a/img"));

		for (int i = 1; i <= rb.size(); i++) {
			driver.findElement(By.xpath("//ul[@id='right_top_event_banner']/li[" + i + "]/a/img")).click();
			Thread.sleep(3000);

			// 404 체크
			setup.Failcheck();
		}
	}

	@Test
	public void MainTodaybanner() throws Exception {
		System.out.println("오늘의 혜택");
		List<WebElement> tb = driver.findElements(By.xpath("//ul[@id='today_deal_banner']/li/a/img"));
		System.out.println("오늘의 혜택 수 :" + tb.size());

		for (int i = 1; i <= tb.size(); i++) {
			driver.findElement(By.xpath("//ul[@id='today_deal_banner']/li[" + i + "]/a/img")).click();
			Thread.sleep(3000);

			// 404 체크
			setup.Failcheck();
		}
	}

}
