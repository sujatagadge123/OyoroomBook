package com.oyoroombook.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oyoroombook.Base.TestBase;

public class LogOffPage extends TestBase {

	By back = By.xpath("");
	By welcome = By.xpath("");
	By signout = By.xpath("");

	public boolean validateLogOff() {

		driver.findElement(back).click();
		wait(2000);
		driver.findElement(welcome).click();
		wait(2000);
		driver.findElement(signout).click();
		wait(2000);

		boolean actResult = true;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div[6]/div[2]/div/div[1]/div/span[2]/span")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for Logout failure");
			captureScreenshot();
		}
		return actResult;

	}

}
