package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class FWebdriverUtility {

	WebDriver driver;
	
	public FWebdriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	public void maximizeScreen() {
		driver.manage().window().maximize();
	}
	
	public void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public String screenshot() throws IOException {
		TakesScreenshot tss = (TakesScreenshot)driver;
		File tempfile = tss.getScreenshotAs(OutputType.FILE);
		File permfile = new File("./Defect screenshots/defect"+String.valueOf(new Date()).replace(' ' , '_').replace(':', '_')+".png");
		Files.copy(tempfile, permfile);
		
		return permfile.getAbsolutePath();
	}
	
}
