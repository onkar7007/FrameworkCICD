package rahulshettyacademy.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	@FindBy(css=".action__submit")
	WebElement submit;
	By item= By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {
	Actions a =new Actions(driver);
	a.sendKeys(country,countryName).build().perform();
	waitForElementToAppear(item);
	selectCountry.click();
	}
	public confirmationPage submitOrder() {
		submit.click();
		return new confirmationPage(driver);
	}

}
