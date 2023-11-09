package tests;

import java.util.List;

import org.testng.Assert;

import pages.HomePage;

public class TestCase22 extends TestBasic{

	 public void AddToCartFromRecommendedItems() {
	        verifyRecommendedItemsAreVisible();
	        verifyThatProductIsDisplayedInCartPage();
	    }

	    @Step("Verify 'RECOMMENDED ITEMS' are visible")
	    private void verifyRecommendedItemsAreVisible() {
	        String recommendedItemsText = new HomePage(getDriver())
	                .getRecommendedItems()
	                .getText();
	        Assert.assertEquals(recommendedItemsText, "RECOMMENDED ITEMS", "Verify 'RECOMMENDED ITEMS' are visible");
	    }

	    @Step("Verify that product is displayed in cart page")
	    private void verifyThatProductIsDisplayedInCartPage() {
	        List<String> productsNames = new HomePage(getDriver())
	                .blueTopAddToCartButtonClick()
	                .viewCartButtonClick()
	                .getProductsNames();
	        Assert.assertEquals(productsNames.get(0), "Blue Top", "Verify that product is displayed in cart page");
	    }

}
