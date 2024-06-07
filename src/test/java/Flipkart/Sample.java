package Flipkart;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Sample {

	@Test
	public void hh() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.flipkart.com/");
		TakesScreenshot tss = (TakesScreenshot) driver;
		
		File temp = tss.getScreenshotAs(OutputType.FILE);
		File perm = new File(".\\Defect screenshots\\defect.png");
		Files.copy(temp, perm);
		
		
	}
	
}
