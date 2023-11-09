package tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import pages.CartPage;
import pages.HomePage;
import pages.JSONReader;
import pages.LoggedHomePage;

public class TestCase16 extends TestBasic {
	 public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
    TestCase1.verifyThatHomePageIsVisibleSuccessfully();
    new HomePage(getDriver())
            .signupLoginClick()
            .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
    verifyLoggedInAsUsernameAtTop();
    TestCase14.verifyThatCartPageIsDisplayed();
    new CartPage(getDriver()).proceedToCheckoutButtonClick();
    TestCase14.verifyAddressDetailsAndReviewYourOrder();
    TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
}

@Step("Verify 'Logged in as username' at top")
private void verifyLoggedInAsUsernameAtTop() throws IOException, ParseException {
    String username = new LoggedHomePage(getDriver())
            .getUsername()
            .getText();
    Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify 'Logged in as username' at top");
  }


}
