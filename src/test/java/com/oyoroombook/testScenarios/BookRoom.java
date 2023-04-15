package com.oyoroombook.testScenarios;

import org.testng.annotations.Test;

import com.oyoroombook.Pages.ContinueToBookPage;
import com.oyoroombook.Pages.EnterCustomerDetailsPage;
import com.oyoroombook.Pages.LogOffPage;
import com.oyoroombook.Pages.LoginPage;
import com.oyoroombook.Pages.SearchRoomPage;
import com.oyoroombook.Pages.SelectRoomPage;
import com.oyoroombook.Base.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class BookRoom extends TestBase {
	@Test(enabled = false)
	public void loginTest() {
		LoginPage loginTest = new LoginPage();
		boolean actResult = loginTest.validateLogin("9689020992");
		Assert.assertTrue(actResult);

	}

	@Test(priority = 1)
	public void searchRoomTest() {
		SearchRoomPage searchTest = new SearchRoomPage();
		boolean actResult = searchTest.validateSearchProduct("Pune");
		Assert.assertTrue(actResult);

	}

	@Test(priority = 2)
	public void selectRoomTest() {
		SelectRoomPage selectTest = new SelectRoomPage();
		boolean actResult = selectTest.validateSelectRoom();
		Assert.assertTrue(actResult);

	}

	@Test(priority = 3)
	public void bookRoomTest() {
		ContinueToBookPage continueTest = new ContinueToBookPage();
		boolean actResult = continueTest.validateContinueToBook();
		Assert.assertTrue(actResult);

	}
	
	@Test(priority = 4)
	public void enterCustomerDetailsTest() {
		EnterCustomerDetailsPage customerDetailsTest = new EnterCustomerDetailsPage();
		boolean actResult = customerDetailsTest.validateCustomerDetails("Sujata Gadge", "Sujatag@gmail.com", "9867564567");
		Assert.assertTrue(actResult);

	}

	@Test(enabled = false)
	public void logoutTest() {
		LogOffPage logoffTest = new LogOffPage();
		boolean actResult = logoffTest.validateLogOff();
		Assert.assertTrue(actResult);

	}

	@BeforeClass
	public void beforeClass() {
		launchBrowser();
		navigateToURL();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
