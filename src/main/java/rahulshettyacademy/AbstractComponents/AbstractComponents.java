package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.PageObjectModel.cartPage;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitFoWebElementToAppear(WebElement findBy) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public cartPage goToCartHeader() {
		cartHeader.click();
		cartPage cartp=new cartPage(driver);
		return cartp;
	}
	public  goToOrderPage goToOrderPage() {
		orderHeader.click();
		goToOrderPage orderp=new goToOrderPage(driver);
		return orderp;
	}

}
