package rahulshettyacademy.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class goToOrderPage extends AbstractComponents{
	WebDriver driver;
	public goToOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match=productNames.stream().anyMatch(productname->productname.getText().equalsIgnoreCase(productName));
		return match;
	}

}
