package com.newbikes.pageModels;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.newbikes.base.baseUI;
import org.openqa.selenium.interactions.Actions;

public class NewBikesPage extends baseUI{
	
		//To load the main site
		public void Load_Home_Page(String browser) throws InterruptedException{
			invokeBrowser(browser);
			driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			openUrl("https://www.zigwheels.com/");
		}
		
		
		//To search "Upcoming Honda Bikes" in the search box
		public void searchBox1(String searchText) throws InterruptedException{
		    enterText("//*[@id=\"headerSearch\"]",searchText);
			clickXpath("//*[@id='search-Sml']/span[3]");
			Thread.sleep(3000);
			clickXpath("//*[@id=\"main_section\"]/div[2]/ul/li/a");
			Thread.sleep(5000);		
		}
		
		//To search "Upcoming Honda Bikes Under 4 Lakhs" in the search box
		public void searchBox2(String searchText) throws InterruptedException{
			enterText("//*[@id=\"headerSearch\"]",searchText);
			clickXpath("//*[@id='search-Sml']/span[3]");
			Thread.sleep(5000);
			String resultText=driver.findElement(By.xpath("//*[@id=\"content_search_result_div\"]/div[2]")).getText();
			System.out.println(resultText);
		}
		
		//To select "Upcoming Bikes" option through mouse hover
		public void mouseHover() throws InterruptedException{
			WebElement newBikes=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/a"));
			Actions builder=new Actions(driver);
			builder.moveToElement(newBikes).build().perform();
			setWaitByClick("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/span");
			WebElement upcomingBikes=driver.findElement(By.xpath("//*[@id=\"headerNewNavWrap\"]/div[2]/ul/li[3]/ul/li/div[1]/ul/li[3]/span"));
			upcomingBikes.click();
			Thread.sleep(3000);		
		}
}
