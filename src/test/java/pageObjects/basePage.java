package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtility;

public class basePage {
	
	public static WebDriver driver;
	public static ExcelUtility eu = new ExcelUtility("assign.xlsx");
	static WebDriverWait mywait;
	
	public basePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
		mywait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
	}
	public void sleep(long sleep) {
		try {
			Thread.sleep(sleep);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
