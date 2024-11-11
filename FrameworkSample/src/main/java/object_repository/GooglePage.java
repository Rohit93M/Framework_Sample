package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_lib.WebDriverUtility;


public class GooglePage {
	WebDriver driver;
	public WebDriverUtility webDriverUtils = new WebDriverUtility();

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	WebElement searchTF;
	
	@FindBy(name = "btnK")
	WebElement searchButton;

	public void search(String text) {
		searchTF.sendKeys(text);
	}
	
	public void clickBtn() {
		//webDriverUtils.waitTillElementToBeClickable(driver, searchButton);
		searchButton.submit();
	}
}
