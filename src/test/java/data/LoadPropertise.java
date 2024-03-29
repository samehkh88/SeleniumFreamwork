package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertise {

	
	public static Properties user = getPropValues(System.getProperty("user.dir")+"\\src\\main\\java\\propertise\\userdata.propertise");
	public static Properties Sauceuser = getPropValues(System.getProperty("user.dir")+"\\src\\main\\java\\propertise\\Saucelabs.propertise");
	
	private static  Properties getPropValues(String path)
	{
		
	Properties prop = new Properties();
	
	try {
		//stream for loading file
		FileInputStream stream = new FileInputStream(path);
		prop.load(stream);
		
	} catch (FileNotFoundException e) {
		System.out.println("the Error message is" + e);
	} catch (IOException e) {
		System.out.println("the Error message is" + e);
	}catch (NullPointerException e) {
		System.out.println("the Error message is" + e);
	}
	
	return prop;
	
}
}