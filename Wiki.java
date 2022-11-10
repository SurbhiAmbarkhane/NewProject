package main_java;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class Wiki extends BaseClass {
	//Locators
	@FindBy(xpath="//input[@id='searchInput']")WebElement searchBoxW;
	
	@FindBy(xpath="//i[text()='Search']")WebElement searchW;
	
	@FindBy(xpath ="//*[@href='/wiki/Pushpa:_The_Rise'and @title='Pushpa: The Rise']//parent::div")WebElement movieW;
	
	@FindBy(xpath="//div[text()='Release date']//parent::th//following-sibling::td")WebElement releaseDateW;
	
	@FindBy(xpath="//th[text()='Country']//parent::th//following-sibling::td")WebElement countryW;
	
	//Initialization of locators/variables
			public Wiki(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver, this);
				}
		
@BeforeMethod 
public   void wikipedia() throws IOException {
	
 	driver.get("https://www.wikipedia.org/");
 	driver.manage().window().maximize();
	driver.manage().timeouts().getPageLoadTimeout();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	searchBoxW.sendKeys("Pushpa: The Rise");
	searchW.click();
	movieW.click();
}
public  String mvDateWiki() {
	
	String releaseDateOnWiki=releaseDateW.getText();
	return releaseDateOnWiki;

}
public  String mvCountryWiki() {
	
	String counrtyOnWiki=releaseDateW.getText();
	return counrtyOnWiki;
}

		

}


