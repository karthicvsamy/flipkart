package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchpagePage {

	WebDriver driver;
	
	public SearchpagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public List<String> getListOfEveryMobiles(){
		List<WebElement> mobiles = driver.findElements(By.xpath("//div[@class='tUxRFH']/descendant::div[@class='KzDlHZ']"));
		List<String> asc = new ArrayList<String>();
		
		for(WebElement x:mobiles) {
			asc.add(x.getText());
		}
		
		return asc;
	}
	
	public void printMobilesAndPrice(List<String> names) {
		
		for(String pname:names) {
			WebElement ele = driver.findElement(By.xpath("//div[.='"+pname+"']/ancestor::div[@class='tUxRFH']/descendant::div[@class='Nx9bqj _4b5DiR']"));
			System.out.println(pname+" ==> "+ele.getText());
		}
	}
}
