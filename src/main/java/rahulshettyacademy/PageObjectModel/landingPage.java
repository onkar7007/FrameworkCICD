package rahulshettyacademy.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

//Page object will not hold any data It will hold only elements and actions.
public class landingPage extends AbstractComponents {
	WebDriver driver;
	public landingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//driver.findElement(By.id("userEmail"))
	@FindBy(id="userEmail")
	WebElement username;
	//driver.findElement(By.id("userPassword"))
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errormsg;
	
	public productCatalogue applicationLogin(String email,String pswd) {
		username.sendKeys(email);
		passwordEle.sendKeys(pswd);
		submit.click();
		productCatalogue productCatalogue=new productCatalogue(driver);
		return productCatalogue;
	}
	
	public String geterrorMessage() {
		waitFoWebElementToAppear(errormsg);
		return errormsg.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
