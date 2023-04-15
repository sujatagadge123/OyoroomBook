package com.oyoroombook.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oyoroombook.Base.TestBase;

public class ContinueToBookPage extends TestBase {

	By FirstRoom = By.xpath("//*[@id=\"1202\"]/div/div/div[1]/div[1]/h1");

	By ContinueToBook = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div[4]/div[2]/div[2]/div[6]/button/span");

	public boolean validateContinueToBook() {

		System.out.println("First Room Name = " + driver.findElement(FirstRoom).getText());
		wait(2000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)");

		wait(2000);

		driver.findElement(ContinueToBook).click();
		wait(2000);

		boolean actResult = true;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div[6]/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for ContinueToBook failure");
			captureScreenshot();
		}
		return actResult;

	}

}
