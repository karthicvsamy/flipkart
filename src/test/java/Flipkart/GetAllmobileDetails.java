package Flipkart;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomepagePage;
import elementRepository.SearchpagePage;
import genericUtilities.FBaseClass;



public class GetAllmobileDetails extends FBaseClass{

	@Test
	public void getAllMobileDetails() throws EncryptedDocumentException, IOException {
		
		HomepagePage home = new HomepagePage(driver);
		SearchpagePage searchPage = new SearchpagePage(driver);
		
		Assert.assertEquals(false, true);
		
		home.searchWithText(eutils.getStringValue("Sheet1", 1, 0));
		
		List<String> mobiles = searchPage.getListOfEveryMobiles();
		
		Collections.sort(mobiles,Collections.reverseOrder());
		searchPage.printMobilesAndPrice(mobiles);
		
	}
	
}
