package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	//Actions actions = new Actions(driver);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Demo Site")
	private WebElement demoSitesLink;

	@FindBy(linkText = "Free Tutorials")
	private WebElement freeTutorialsLink;

	@FindBy(linkText = "Test Demo Site")
	private WebElement testDemoSiteLink;

	@FindBy(css = "img[src='images/lgn.png']")
	private WebElement memberLoginButton;

	//By memberLoginButton = By.cssSelector("a[src=\"images/lgn.png\"']");



	public void clickDemoSiteLink() {
		demoSitesLink.click();
	}

	public void clickFreeTutorialsLink() {
		freeTutorialsLink.click();
	}

	public void clickTestDemoSiteLink() {
		//Mouse over to Demo Site link and click test demo site link in the menu
		Actions actions = new Actions(driver);
		actions.moveToElement(demoSitesLink).build().perform();
		testDemoSiteLink.click();

	}

	public void clickMemberLoginButton() {

		memberLoginButton.click();
	}
}
