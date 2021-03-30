package com.newbikes.pageModels;

import java.io.FileNotFoundException;
import java.util.Set;
import org.openqa.selenium.By;

import com.newbikes.base.baseUI;



public class LoginPage extends baseUI {
		
	public String parentHandle = "";
	

	public void setupWebsite(String browser) throws InterruptedException, FileNotFoundException {
		//To open parent window of zigwheels
		invokeBrowser(browser);
		openUrl(getPropertyValue("website"));
		parentHandle =driver.getWindowHandle();
		
		
	}
	
	public void openLoginWindow(String loginSite) throws InterruptedException {
		//To click on the login button
		clickXpath("//div[@id='des_lIcon']");
		Thread.sleep(3000);
		
		//To click on the login with google/facebook button
		clickXpath("//span[contains(text(),'Continue with " + loginSite + "')]");
		waitImplicit();
		
		//To switch to child window
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle : windowHandles) {
			if(!(windowHandle.equals(parentHandle))) {
			driver.switchTo().window(windowHandle);
			}
		}
		Thread.sleep(3000);
	}

	
	
	public void enterCredentials(String email,String password) throws InterruptedException {
		//To enter login credentials in facebook window
		setWaitByPresence("//input[@id='email']");
		enterText("//input[@id='email']",email);
		enterText("//input[@id='pass']", password);
		driver.findElement(By.xpath("//input[@name='login']")).submit();
		
	}
	
	public void enterCredentials(String email) throws InterruptedException {
		//To enter login credentials in google window
		enterText("//input[@type='email']",email);		
		clickXpath("//button[@type='button']");
	}
	
	public String getErrorMessageFacebook() throws InterruptedException {
		//To get the error message displayed by facebook
		String path= "//div[@id='error_box']/div[1]";
		setWaitByVisibility(path);
		String error = driver.findElement(By.xpath(path)).getText();
		System.out.println(error);
		return error;
	}
	
}