package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class myAssignment extends basePage {

	public myAssignment(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='quickActionColAppHolder']//div[text()='View Assignments']")
	WebElement viewAssignment;
	
	@FindBy(xpath="//h2/span[text()='My Assignments']")
	WebElement myAssignment;

	@FindAll(@FindBy(xpath = "//thead/tr/th"))
	List<WebElement> project_nav;
	
//	@FindAll(@FindBy(tagName = "th"))
//	List<WebElement> cells;

	@FindAll(@FindBy(xpath = "//tr[@class='ps_grid-row']//div//span[@class='ps_box-value']"))
	List<WebElement> project_details;
	
	

	public void viewAssign() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", viewAssignment);

		sleep(2000);
		viewAssignment.click();
	}

	public void navigateToWindow() {

		Set<String> windowIDs = driver.getWindowHandles();
		List<String> windowIDsList = new ArrayList<String>(windowIDs);
//		driver.switchTo().window(windowIDsList.get(0));

		for (String winId : windowIDsList) {
			String title = driver.switchTo().window(winId).getTitle();
			if (title.equals("Resource Dashboard")) {
				driver.switchTo().window(winId);
			}
		}
	}

	public void printResult() {

		WebElement myAssign = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2/span[text()='My Assignments']")));
		System.out.println(project_nav.size());
		for (WebElement pro_nav : project_nav) {
			System.out.println(pro_nav.getText());
		}
//		sleep(5000);
//		int size = rows.size();
//		System.out.println(size);
//		for(int i=0;i<size-1;i++) {
//			
//			for(WebElement cell:cells) {
//				System.out.println(cell.getText());
//			}
//			
//			
//		}
	}

}
