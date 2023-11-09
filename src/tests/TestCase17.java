package tests;

import org.testng.Assert;

import pages.CartPage;

public class TestCase17 extends TestBasic{

	 public void removeProductsFromCart() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase14.verifyThatCartPageIsDisplayed();
	        verifyThatProductIsRemovedFromTheCart();
	    }

	    @Step("Verify that product is removed from the cart")
	    private void verifyThatProductIsRemovedFromTheCart() {
	        String emptyCartText = new CartPage(getDriver())
	                .xButtonClick()
	                .getEmptyCartSpan()
	                .getText();
	        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");
	    }
}
