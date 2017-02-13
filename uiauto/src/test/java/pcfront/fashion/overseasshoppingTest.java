package pcfront.fashion;

import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pcfront.main.setup;

public class overseasshoppingTest extends setup {
	@Test
	public void Fashion_overseasshopping() throws Exception {
		driver.get("http://wemakeprice.com/main/101400");
		List<WebElement> rb = driver.findElements(By.xpath("//div[2]/div/ul/li/a/img"));
		List<WebElement> rb1 = driver.findElements(By.xpath("//div[3]/ul/li/a/img"));

		// 상단 작은배너 체크
		if (rb.size() > 0) {
			System.out.println("상단 작은배너:" + rb.size());
			for (int i = 1; i <= rb.size(); i++) {
				driver.findElement(By.xpath("//div[2]/div/ul/li[" + i + "]/a/img")).click();
				Thread.sleep(3000);
				setup.Failcheck();
			}
		} else {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "에 배너가 없습니다.");
		}

		// 하단 배너 체크
		if (rb1.size() > 0) {
			System.out.println("하단 배너:" + rb1.size());
			for (int i = 1; i <= rb1.size(); i++) {
				driver.findElement(By.xpath("//div[3]/ul/li[" + i + "]/a/img")).click();
				Thread.sleep(3000);
				// 404 체크
				setup.Failcheck();
			}
		} else {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "에 배너가 없습니다.");

		}
	}
}
