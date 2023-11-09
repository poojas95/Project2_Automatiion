package tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import pages.ProductDetailPage;
import pages.ProductsPage;

public class TestCase21 extends TestBasic {

	 public void addReviewOnProduct() throws IOException, ParseException {
	        TestCase8.verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        verifyWriteYourReviewIsVisible();
	        verifySuccessMessageThankYouForYourReview();
	    }

	    @Step("Verify 'Write Your Review' is visible")
	    private void verifyWriteYourReviewIsVisible() {
	        String writeYourReviewText = new ProductsPage(getDriver())
	                .viewProductOfFirstProductButtonClick()
	                .getWriteYourReview()
	                .getText();
	        Assert.assertEquals(writeYourReviewText, "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");
	    }

	    @Step("Verify success message 'Thank you for your review.'")
	    private void verifySuccessMessageThankYouForYourReview() throws IOException, ParseException {
	        String successMessageText = new ProductDetailPage(getDriver())
	                .fillReview()
	                .getSuccessMessage()
	                .getText();
	        Assert.assertEquals(successMessageText, "Thank you for your review.", "Verify success message 'Thank you for your review.'");
	    }
}
