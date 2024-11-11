package generic_lib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public WebDriverUtility webDriverUtils = new WebDriverUtility();
	public PropertyFileUtility fileUtils = new PropertyFileUtility();
	public ExcelFileUtility excelUtils = new ExcelFileUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite
	public void configBS() {
		System.out.println("Starting Report Configuration");
	}

	@BeforeClass
	public void configBC() throws IOException {
		
		System.out.println("Launching the browser");
		
		String browser = fileUtils.getDataFromPropertyFile("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new ChromeDriver();
		} else
			driver = new ChromeDriver();

		driver.get(fileUtils.getDataFromPropertyFile("url"));
		webDriverUtils.maximizeBrowser(driver);
		webDriverUtils.waitToFindElements(driver, 20);
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		String url = fileUtils.getDataFromPropertyFile("url");
		driver.get(url);
	}

	@AfterClass
	public void configAC() {
		
		System.out.println("Closing the browser");
		driver.quit();
	}

}
