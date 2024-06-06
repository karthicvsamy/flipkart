package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class FBaseClass {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	public FileUtility file = new FileUtility();
	public ExcelUtility eutils = new ExcelUtility();
	public FWebdriverUtility wutil;
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		
		if(file.getValue("flipkart", "browser").equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(file.getValue("flipkart", "browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser name not matching");
		}
		
		sDriver = driver;
		wutil = new FWebdriverUtility(driver);
		wutil.maximizeScreen();
		wutil.implicitWait(10);
		
		driver.get(file.getValue("flipkart", "url"));
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
