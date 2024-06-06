package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtility {
	
	public String getValue(String fileName,String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\"+fileName+".properties");
		Properties propObj = new Properties();
		propObj.load(fis);
		return propObj.getProperty(key);
	}
	
}
