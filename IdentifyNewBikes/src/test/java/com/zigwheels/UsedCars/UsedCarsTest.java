package com.zigwheels.UsedCars;

import static org.testng.Assert.assertEquals;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.newbikes.base.WriteExcelSheet;
import com.newbikes.pageModels.UsedCars;

public class UsedCarsTest extends UsedCars {
	
	@Test(priority=1)
	public void extractUsedCarsModel1() throws Exception {
		setupWebsite("Chrome");
		findUsedCars("//header/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]");
		selectLocation("//span[@data-track-label='used-cars-chennai']");
		String pageTitle= driver.getTitle();
		ExtentTest logger=report.createTest("Used Cars Page - Test 1");
		if(pageTitle.equals("Used Cars in Chennai - Certified Second Hand Cars for Sale @ ZigWheels"))
		{
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		
		ArrayList<String>models=printModels("//body/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[2]/div[4]", "Chennai");
		WriteExcelSheet.writeData(models,"Used Cars","List of Used cars in Chennai", "UsedCarsChennaiTest.xlsx");
		assertEquals(pageTitle,"Used Cars in Chennai - Certified Second Hand Cars for Sale @ ZigWheels");
		takeScreenshot(driver);
		quitBrowser();
		
	}
	
	@Test(priority=2)
	public void extractUsedCarsModel2() throws Exception {
		setupWebsite("Chrome");
		findUsedCars("//header/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]");
		selectLocation("//span[contains(text(),'Bangalore')]");
		
		String pageTitle= driver.getTitle();
		ExtentTest logger=report.createTest("Used Cars Page - Test 2");
		if(pageTitle.equals("Used Cars in Bangalore - Certified Second Hand Cars for Sale @ ZigWheels"))
		{
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		ArrayList<String>models=printModels("//body/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[2]/div[4]", "Bangalore");
		WriteExcelSheet.writeData(models,"Used Cars","List of Used cars in Bangalore", "UsedCarsBangaloreTest.xlsx");
		assertEquals(pageTitle,"Used Cars in Bangalore - Certified Second Hand Cars for Sale @ ZigWheels");
		takeScreenshot(driver);
		quitBrowser();
		
	}
	
	@Test(priority=3)
	public void extractUsedCarsModel3() throws Exception {
		setupWebsite("Mozilla");
		findUsedCars("//header/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]");
		selectLocation("//span[contains(text(),'Kolkata')]");
		String pageTitle= driver.getTitle();
		ExtentTest logger=report.createTest("Used Cars Page - Test 3");
		if(pageTitle.equals("Used Cars in Kolkata - Certified Second Hand Cars for Sale @ ZigWheels"))
		{
		logger.log(Status.PASS,"Test Executed Successfully");
		}
		else
		{
		logger.log(Status.FAIL, "Test Failed");
		}
		ArrayList<String>models=printModels("//body/div[11]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/div[2]/div[4]","Kolkata");
		
		WriteExcelSheet.writeData(models,"Used Cars","List of Used cars in Kolkata", "UsedCarsKolkataTest.xlsx");
		assertEquals(pageTitle,"Used Cars in Kolkata - Certified Second Hand Cars for Sale @ ZigWheels");
		takeScreenshot(driver);
		quitBrowser();
		
	}
}
