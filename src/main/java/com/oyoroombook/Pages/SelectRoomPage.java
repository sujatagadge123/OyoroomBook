package com.oyoroombook.Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.oyoroombook.Base.TestBase;

public class SelectRoomPage extends TestBase {

	By FirstRoom = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/a/h3");
			
	public boolean validateSelectRoom() {


		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window: " + parentWindow);

		driver.findElement(FirstRoom).click();
		wait(2000);

		Set<String> allWindows = driver.getWindowHandles();

		for (String eachWindow : allWindows)

		{
			System.out.println(parentWindow + "\t" + eachWindow);

			if (!parentWindow.equals(eachWindow)) {
				System.out.println("Child Window " + eachWindow);

				driver.switchTo().window(eachWindow);
				System.out
						.println(driver.findElement(By.xpath("//*[@id=\"1202\"]/div/div/div[1]/div[1]/h1")).getText());

			}
		}

		boolean actResult = true;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@id=\"1202\"]/div/div/div[1]/div[1]/h1")));

		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for SelectResult failure");
			captureScreenshot();
		}
		return actResult;

	}
}
