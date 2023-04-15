package com.oyoroombook.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oyoroombook.Base.TestBase;

public class EnterCustomerDetailsPage extends TestBase{
	
	By name = By.id("name");
	By email = By.id("email");
	By mobile = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div[6]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[1]/div[4]/div[2]/input");
	By passcode = By.xpath("/html/body/div[1]/div/div[3]/div/div/div[2]/div[6]/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[1]/div[5]/div/button");
	
	
	public boolean validateCustomerDetails(String Name, String Email, String Mobile) {

		driver.findElement(name).sendKeys(Name);
		wait(2000);
		driver.findElement(email).sendKeys(Email);
		wait(2000);
		driver.findElement(mobile).sendKeys(Mobile);
		wait(2000);
		driver.findElement(passcode).click();
		wait(2000);
		

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"otp\"]")));
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for customerDetails failure");
			captureScreenshot();
		}

		return actResult;

	}


}
