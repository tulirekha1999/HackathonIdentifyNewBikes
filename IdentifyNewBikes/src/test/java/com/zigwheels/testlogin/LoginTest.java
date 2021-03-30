package com.zigwheels.testlogin;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.newbikes.base.readDataSheet;
import com.newbikes.pageModels.LoginPage;


public class LoginTest extends LoginPage{
	
	//Method to get cell data from excel
	public static String getData(int colNum, int rowNum) throws Exception {
		readDataSheet dataprovider=new readDataSheet();
		dataprovider.openWorkbook("Email_password_Dataset.xlsx");
		return dataprovider.getCellData("Sheet1", colNum, rowNum);
	}
	
	@Test(priority=1)
	public void testOne() throws Exception {
		
		
		String email= getData(0, 1);
		setupWebsite("chrome");
		openLoginWindow("Google");
		enterCredentials(email);
		String pageTitle= driver.getTitle();
		
		ExtentTest logger=report.createTest("Login Page - Test 1");
		if(pageTitle.equals("Sign in – Google accounts"))
		{
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		assertEquals(pageTitle,"Sign in – Google accounts");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
		
		
	}
	
	@Test(priority=2)
	public void testTwo() throws Exception {
		String email= getData(0, 2);
		setupWebsite("chrome");
		openLoginWindow("Google");
		enterCredentials(email);
		String pageTitle= driver.getTitle();
		ExtentTest logger=report.createTest("Login Page - Test 2");
		if(pageTitle.equals("Sign in – Google accounts"))
		{
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		assertEquals(pageTitle,"Sign in – Google accounts");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
	}
	
	@Test(priority=3)
	public void testThree() throws Exception {
		String email= getData(0, 3);
		setupWebsite("mozilla");
		openLoginWindow("Google");
		enterCredentials(email);
		String pageTitle= driver.getTitle();
		ExtentTest logger=report.createTest("Login Page - Test 3");
		if(pageTitle.equals("Sign in – Google accounts"))
		{
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		assertEquals(pageTitle,"Sign in – Google accounts");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
		
	}
	
	@Test(priority=4)
	public void testFour() throws Exception {
		String email= getData(0, 4);
		String pass= getData(1, 4);
		setupWebsite("mozilla");
		openLoginWindow("Facebook");
		enterCredentials(email, pass);
		;
		String pageTitle=driver.getTitle();
		ExtentTest logger=report.createTest("Login Page - Test 4");
		if(pageTitle.equals("Facebook"))
		{
			
		logger.log(Status.INFO, getErrorMessageFacebook());
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		assertEquals(pageTitle,"Facebook");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
		
	}
	
	@Test(priority=5)
	public void testFive() throws Exception {
		String email= getData(0, 5);
		String pass= getData(1, 5);
		setupWebsite("mozilla");
		openLoginWindow("Facebook");
		enterCredentials(email, pass);
		getErrorMessageFacebook();
		String pageTitle=driver.getTitle();
		
		ExtentTest logger=report.createTest("Login Page - Test 5");
		if(pageTitle.equals("Facebook"))
		{
			
		logger.log(Status.INFO, getErrorMessageFacebook());
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		assertEquals(pageTitle,"Facebook");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
		
	}
	
	@Test(priority=6)
	public void testSix() throws Exception {
		String email= getData(0, 6);
		String pass= getData(1, 6);
		setupWebsite("chrome");
		openLoginWindow("Facebook");
		enterCredentials(email, pass);
		getErrorMessageFacebook();
		String pageTitle=driver.getTitle();
		ExtentTest logger=report.createTest("Login Page - Test 6");
		if(pageTitle.equals("Facebook"))
		{
			
		logger.log(Status.INFO, getErrorMessageFacebook());
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		assertEquals(pageTitle,"Facebook");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
		
	}

	@Test(priority=7)
	public void testSeven() throws Exception {
		String email= getData(0, 7);
		String pass= getData(1, 7);
		setupWebsite("chrome");
		openLoginWindow("Facebook");
		enterCredentials(email, pass);
		getErrorMessageFacebook();
		String pageTitle=driver.getTitle();
		ExtentTest logger=report.createTest("Login Page - Test 7");
		if(pageTitle.equals("Facebook"))
		{
			
		logger.log(Status.INFO, getErrorMessageFacebook());
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}

		
		assertEquals(pageTitle,"Facebook");
		takeScreenshot(driver);
		closeBrowser();
		quitBrowser();
		
	}
}
