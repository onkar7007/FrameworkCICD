package rahulshettyacademy.PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents{
	WebDriver driver;
	public cartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	@FindBy(xpath="//*[@class='totalRow'] //button[contains(@class,'btn-primary')]")
	WebElement checkoutele;

	public Boolean VerifyProductDisplay(String productName) {
		Boolean match=cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckOut() {
		checkoutele.click();
		return new CheckoutPage(driver);
	}
	
	
}