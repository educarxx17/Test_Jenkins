package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class DemoHomePage {

	WebDriver driver;

	private String pageUrl = "http://www.way2automation.com/demo.html";
	List<String> services = Arrays.asList("Strategy Consulting", "HR", "Digital Marketing", "Traditional Marketing",
			"Accounting and Finance", "Deal Advisory", "Sales & Operations");

	public DemoHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "c-banner__title")
	private WebElement bannerTitleText;

	@FindBy(className = "heading")
	private List<WebElement> serviceTypes;

	public void verifyDemoSitePage() {
		String strUrl = driver.getCurrentUrl();
		System.out.println("*** verifyDemoSitePage : "+strUrl);
		Assert.assertEquals( pageUrl, strUrl);
	}

	public void verifyDemoSiteTitle() {

		String strTitle = driver.getTitle();
		System.out.println("*** verifyServiceTitle : "+strTitle);
		Assert.assertEquals("Welcome", strTitle);

	}
}
