package sample_package;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import generic_lib.BaseClass;

public class SampleTest extends BaseClass {

	@Test
	public void sampleTest01() throws InterruptedException {
    driver.switchTo().newWindow(WindowType.TAB);
    driver.navigate().to("https://www.facebook.com/");
    driver.quit();
    driver.close();
	}
}
