package testCases;

import org.testng.annotations.Test;

import pageObjects.myAssignment;
import testBase.baseClass;

public class TC_001_viewAssign extends baseClass{
  @Test(priority = 1)
  public void verify_viewAssign() {
	  
	  myAssignment ma = new myAssignment(driver);
	  ma.viewAssign();
	  ma.navigateToWindow();
	  ma.printResult();
	  
	  
  }
}
