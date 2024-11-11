package generic_lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/config_data.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String data = properties.getProperty(key);
		return data;
	}
}
