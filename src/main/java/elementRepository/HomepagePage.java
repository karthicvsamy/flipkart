package elementRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePage {
	WebDriver driver;
	
	public HomepagePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy (xpath = "//input[@title='Search for Products, Brands and More']")
	private WebElement searchBar;

	
	public WebElement getSearchBar() {
		return searchBar;
	}
	
	public void searchWithText(String text) {
		getSearchBar().sendKeys(text+Keys.ENTER);
	}
	
}
