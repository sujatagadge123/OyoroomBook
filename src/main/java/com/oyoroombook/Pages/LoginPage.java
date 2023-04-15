package com.oyoroombook.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.oyoroombook.Base.TestBase;

public class LoginPage extends TestBase {

	By Login = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[1]/div/div[2]/div[4]/div/div[2]/div");
	By Mobile = By
			.xpath("/html/body/div[1]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div[3]/input");
	By VerifyN = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/div/button");

	public boolean validateLogin(String MobileN) {

		driver.findElement(Login).click();
		wait(2000);
		driver.findElement(Mobile).sendKeys(MobileN);
		wait(2000);
		driver.findElement(VerifyN).click();
		wait(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[1]/div/div[2]/div[4]/div[1]/div[2]/div")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for login failure");
			captureScreenshot();
		}

		return actResult;

	}

}
