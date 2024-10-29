package rahulshettyacademy.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.AbstractComponents.goToOrderPage;
import rahulshettyacademy.PageObjectModel.CheckoutPage;
import rahulshettyacademy.PageObjectModel.cartPage;
import rahulshettyacademy.PageObjectModel.confirmationPage;
import rahulshettyacademy.PageObjectModel.productCatalogue;
import rahulshettyacademy.testcomponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String productName="ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException,InterruptedException
	{

		productCatalogue productCatalogue=landpage.applicationLogin(input.get("email"),input.get("password") );
		
		List<WebElement> products=productCatalogue.getProductlist();
		productCatalogue.addProductToCart(input.get("product"));
		cartPage cartp=productCatalogue.goToCartHeader();
		Boolean match =cartp.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);//validation cannot go inside page object
		CheckoutPage checkoutpage= cartp.goToCheckOut();
		checkoutpage.selectCountry("india");
		confirmationPage confirmationpage=checkoutpage.submitOrder();
		String msg=confirmationpage.getConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
	}
	@Test(dependsOnMethods={"submitOrder"})	
		public void orderHistoryTest() {
		productCatalogue productCatalogue=landpage.applicationLogin("onkar7007@gmail.com", "Syringe_123");
		goToOrderPage goToOrderPage=productCatalogue.goToOrderPage();
		Assert.assertTrue(goToOrderPage.VerifyOrderDisplay(productName));
		}
	/*
	@DataProvider
	public  Object[][] getData() {
		Object[][] ds= new Object[][] {{"onkar7007@gmail.com", "Syringe_123","ZARA COAT 3"},{"onkar7007@gmail.com", "Syringe_123","ADIDAS ORIGINAL"}};
		return ds;
	}*/

	
	
	@DataProvider
	public  Object[][] getData() throws IOException {
		/*HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "onkar7007@gmail.com");
		map.put("password", "Syringe_123");
		map.put("product", "ZARA COAT 3");
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email", "onkar7007@gmail.com");
		map1.put("password", "Syringe_123");
		map1.put("product", "ADIDAS ORIGINAL");
		Object[][] ds= new Object[][] {{map},{map1}};
		return ds;*/
		
		List<HashMap<String, String>> data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		Object[][] ds= new Object[][] {{data.get(0)},{data.get(1)}};
		return ds;
	}
}
