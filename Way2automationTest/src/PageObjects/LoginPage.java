package PageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	String validationTextExpect = "Invalid email or password";

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h1")
	private WebElement titleText;

	@FindBy(id = "user_email")
	private WebElement emailTextBox;

	@FindBy(id = "user_password")
	private WebElement passwordTextBox;

	//@FindBy(className = "commit")
	@FindBy(css = "input[name='commit']")
	private WebElement loginButton;

	@FindBy(css = "div.alert.alert-danger")
	private WebElement validationText;

	@FindBy(linkText = "Forgot Password?")
	private WebElement forgotPasswordLink;

	//@FindBy(id = "c-feedback--error")
	//private List<WebElement> validationText;

	//@FindBy(className = "c-checkbox-button__label-text")
	//private WebElement intentOption;

	public void clickLoginButton() {
		System.out.println("*** Login page titleText : "+titleText.getText());
		loginButton.click();
	}

	public void verifyValidationText() {
		Assert.assertEquals(validationTextExpect, validationText.getText());
	}

	public void setEmailText(String email) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email+"@t.com");
	}

	public void setPasswordText(String password) {
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	}
}
