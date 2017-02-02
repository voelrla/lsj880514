package pcfront.food;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pcfront.main.setup;
import pcfront.main.urlpath;

public class foodTest extends setup {

	@Test
	public void FoodMainbanner() throws Exception {
		driver.get(urlpath.food);
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
