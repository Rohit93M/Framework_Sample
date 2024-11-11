package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {

	WebDriver driver;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement usernameTextfield;

	public WebElement getUsernameTF() {
		return usernameTextfield;
	}

	@FindBy(id = "pass")
	private WebElement passwordTextField;

	public WebElement getPasswordTF() {
		return passwordTextField;
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}

//	@FindBy(xpath = "//div[@class='_9ay7']")
//	WebElement errorMessage;
//
//	public WebElement getErrorMessage() {
//		return errorMessage;
//	}
//
//	@FindBy(xpath = "//div[@class='_9kpn']")
//	private WebElement verifyAccountTextEle;
//
//	public WebElement getVerifyAccountTextEle() {
//		return verifyAccountTextEle;
//	}
//
//	@FindBy(xpath = "//button[text()='Yes, Continue']")
//	private WebElement continueButton;
//
//	public WebElement getContinueButton() {
//		return continueButton;
//	}
}
