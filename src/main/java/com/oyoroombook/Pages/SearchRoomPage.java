package com.oyoroombook.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oyoroombook.Base.TestBase;

public class SearchRoomPage extends TestBase {

	By City = By.xpath("//*[@id=\"autoComplete__home\"]");
	By Location = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/span/div/div/div[1]/div/div[2]/span/span");
	By Date = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[2]/div/div");
	By Date1 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[2]/div/span/div/div/div[2]/table/tbody/tr[3]/td[5]/span");
	By Date2 = By.xpath(
			"//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[2]/div/span/div/div/div[3]/table/tbody/tr[3]/td[3]/span");
	By Room = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[3]/div/div");
	By Search = By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[3]/div/div[1]/div/div[4]/button");

	public boolean validateSearchProduct(String cityname) {

		driver.findElement(City).sendKeys(cityname);
		wait(2000);
		driver.findElement(Location).click();
		wait(2000);
		driver.findElement(Date).click();
		wait(2000);
		driver.findElement(Date1).click();
		wait(1000);
		driver.findElement(Date2).click();
		wait(1000);
		driver.findElement(Room).click();
		wait(2000);
		driver.findElement(Search).click();
		wait(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"/html/body/div[1]/div/div[3]/div/div/div[3]/section/div/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/a/h3")));

//			List<WebElement> totalrooms = driver.findElements(
//					By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[1]/div[1]/span/h1"));
//			System.out.println("Total no of rooms:" + totalrooms.size());
//
//			for (WebElement eachLap : totalrooms) {
//
//				System.out.println(eachLap.getText());

			// }
		} catch (TimeoutException te) {
			actResult = false;
			System.out.println("screenshot for SearchRoom failure");
			captureScreenshot();
		}

		for (int i = 1; i <= 5; i = i + 2) {
			String oyoRoomName = driver
					.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[2]/div[" + i
							+ "]/div/div[2]/div/div[1]/div[2]/div[1]/a/h3"))
					.getText();
			String roomPrice = driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[3]/div/div/div[3]/section/div/div[2]/div[" + i + "]/div/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/span[1]"))
					.getText();

			System.out.println(oyoRoomName + "\t" + roomPrice);
		}

		return actResult;

	}
}
