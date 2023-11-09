package tests;
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Cart' button
//5. Scroll down to footer
//6. Verify text 'SUBSCRIPTION'
//7. Enter email address in input and click arrow button
//8. Verify success message 'You have been successfully subscribed!' is visible
import java.io.IOException;
import java.text.ParseException;

import pages.HomePage;

public class TestCase11 extends TestBasic{
	public void verifySubscriptionInCartPage() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver()).cartButtonClick();
        TestCase10.verifyTextSubscription();
        TestCase10.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }

}
