package tests;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.testng.Assert;

import pages.HomePage;
import pages.JSONReader;
import pages.ProductsPage;

public class TestCase19 extends TestBasic{

	 public void viewCartBrandProducts() throws IOException, ParseException {
	        verifyThatBrandsAreVisibleOnLeftSideBar();
	        verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed();
	        verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts();
	    }

	    @Step("Verify that Brands are visible on left side bar")
	    private void verifyThatBrandsAreVisibleOnLeftSideBar() {
	        boolean brandsIsDisplayed = new HomePage(getDriver())
	                .productsButtonClick()
	                .getBrands()
	                .isDisplayed();
	        Assert.assertTrue(brandsIsDisplayed, "Verify that Brands are visible on left side bar");
	    }

	    @Step("Verify that user is navigated to brand page and brand products are displayed")
	    private void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() throws IOException, ParseException {
	        String titleTextCenter = new ProductsPage(getDriver())
	                .poloBrandClick()
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(titleTextCenter, "BRAND - POLO PRODUCTS", "Verify that user is navigated to brand page");

	        List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
	        for (int i = 0; i < productsNames.size(); i++) {
	            Assert.assertEquals(productsNames.get(i), JSONReader.poloBrandProducts(String.valueOf(i)), "Verify that brand products are displayed");
	        }
	    }

	    @Step("Verify that user is navigated to that brand page and can see products")
	    private void verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() throws IOException, ParseException {
	        String titleTextCenter = new ProductsPage(getDriver())
	                .madameBrandClick()
	                .getTitleTextCenter()
	                .getText();
	        Assert.assertEquals(titleTextCenter, "BRAND - MADAME PRODUCTS", "Verify that user is navigated to that brand page");

	        List<String> productsNames = new ProductsPage(getDriver()).getProductsSearchNames();
	        for (int i = 0; i < productsNames.size(); i++) {
	            Assert.assertEquals(productsNames.get(i), JSONReader.madameBrandProducts(String.valueOf(i)), "Verify that can see products");
	        }
	   
}
}
