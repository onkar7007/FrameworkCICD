package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.PageObjectModel.cartPage;
import rahulshettyacademy.PageObjectModel.productCatalogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class ErrorValidationTest extends BaseTest{

	@Test//(groups= {"ErrorHandling"},retryAnalyzer=Retry.class) retry analyzer not working here
	public void LoginErrorValidation() throws IOException,InterruptedException
	{
		landpage.applicationLogin("onkar7007@gmail.com", "Syringe");
		Assert.assertEquals(landpage.geterrorMessage(), "Incorrect email password.");
		
	}
	@Test
	public void ProductErrorValidation() {

		String productName="ZARA COAT 3";
		productCatalogue productCatalogue=landpage.applicationLogin("onkar7007@gmail.com", "Syringe_123");
		List<WebElement> products=productCatalogue.getProductlist();
		productCatalogue.addProductToCart(productName);
		cartPage cartp=productCatalogue.goToCartHeader();
		Boolean match =cartp.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

	}
}