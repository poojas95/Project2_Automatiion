package tests;

import java.io.IOException;
import java.text.ParseException;

import pages.CartPage;
import pages.Util;

public class TestCase15 extends TestBasic{

	String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";
	
	 public void placeOrderRegisterBeforeCheckout() throws IOException, ParseException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
	        TestCase14.verifyLoggedInAsUsernameAtTop(name);
	        TestCase14.verifyThatCartPageIsDisplayed();
	        new CartPage(getDriver()).proceedToCheckoutButtonClick();
	        TestCase14.verifyAddressDetailsAndReviewYourOrder();
	        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }
}
