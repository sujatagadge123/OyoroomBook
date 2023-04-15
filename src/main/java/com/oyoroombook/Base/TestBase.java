package com.oyoroombook.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	

		FileInputStream fis; // declare global variable
		public static WebDriver driver; // declare global variable
		Properties prop; // declare global variable

		public void launchBrowser() {

			String fileName = "C:\\Users\\Administrator\\eclipse-workspace\\Oyoroombook_POM\\src\\main\\resources\\config\\config.properties";
			try {
				fis = new FileInputStream(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			prop = new Properties();

			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

			else if (prop.getProperty("Browser").equalsIgnoreCase("edge")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
		}

		public void navigateToURL() {
			driver.get(prop.getProperty("URL"));
		}
		
		public String captureScreenshot() {
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String scrnShotName = "screenshot_" + sdf.format(date) + ".png";
			
			TakesScreenshot scrnShot = (TakesScreenshot) driver;
			File srcfile = scrnShot.getScreenshotAs(OutputType.FILE);
			
			File desfile = new File(".\\src\\test\\resources\\Screenshots\\" + scrnShotName);
			try {
				FileUtils.copyFile(srcfile, desfile);
			} catch(IOException e) {
				e.printStackTrace();
			}
			return scrnShotName;
		}

		public void wait(int msec) {
			try {
				Thread.sleep(msec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
