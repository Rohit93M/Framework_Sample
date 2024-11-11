package generic_lib;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	
	public WebDriver driver;

	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitToFindElements(WebDriver driver, long duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
}
