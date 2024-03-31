package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseClass {
	
	public static WebDriver driver;
	
	public static Properties p;
	
	@BeforeTest
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		
		FileReader file =new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		String Browser=br.toLowerCase();
		
		switch (Browser) {
		case "chrome":driver=new ChromeDriver();
					break;
		case "edge": driver=new EdgeDriver();
					break;
		default:System.out.println("no matchings!");
					return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	


}
