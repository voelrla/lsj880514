package pcfront.service;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pcfront.main.urlpath;
import pcfront.main.setup;

public class serviceTest extends setup {
	@Test
	public void ServiceMainbanner() throws Exception {
		driver.get(urlpath.service);
		List<WebElement> rb = driver.findElements(By.xpath("//ul[@id='promotion_banner']/li/a/img"));
		System.out.println("노출 배너 카운트:" + rb.size());
		for (int i = 1; i <= rb.size(); i++) {
			driver.findElement(By.xpath("//ul[@id='promotion_banner']/li[" + i + "]/a/img")).click();
			Thread.sleep(3000);
			// 404 체크
			setup.Failcheck();
		}
	}
}
