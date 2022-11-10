package main_java;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class IMDB extends BaseClass{
	@FindBy(xpath ="//input[@id='suggestion-search']")WebElement searchBox;
	
	@FindBy(xpath="//button[@id='suggestion-search-button']")WebElement search;
	
	@FindBy(xpath="//a[text()='Pushpa: The Rise - Part 1']") WebElement movieName;
	
	@FindBy(xpath="//a[text()='Release date']//following-sibling::div") WebElement releaseDate;
	
	@FindBy(xpath="//span[text()='Country of origin']//following-sibling::div") WebElement countryOfOrigin;
	
	//Initialization of locators/variables
		public IMDB(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@BeforeMethod 
		public   void imdp() throws IOException {
			
         	driver.get("https://www.imdb.com/");
         	driver.manage().window().maximize();
    		driver.manage().timeouts().getPageLoadTimeout();
    		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    		searchBox.sendKeys("Pushpa: The Rise");
			search.click();
			movieName.click();
		}
		
		public  String mvDateIMDB() {
		
			String releaseDateOnIMDB=releaseDate.getText();
			return releaseDateOnIMDB;
		}
		
		public  String mvCountryIMDB() {
			
			String mvCountyIMDB=countryOfOrigin.getText();
			return mvCountyIMDB;
		}

}
