package tests;

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Scroll down to footer
//5. Verify text 'SUBSCRIPTION'
//6. Enter email address in input and click arrow button
//7. Verify success message 'You have been successfully subscribed!' is visible
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import pages.HomePage;

public class TestCase10 extends TestBasic{
	public void verifySubscriptionInHomePage() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyTextSubscription();
        verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }

    @Step("Verify text 'SUBSCRIPTION")
    public static void verifyTextSubscription() {
        String subscriptionText = new HomePage(getDriver())
                .getSubscription()
                .getText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");
    }

    @Step("Verify success message 'You have been successfully subscribed!' is visible")
    public static void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() throws IOException, ParseException {
        String messageAlert = new HomePage(getDriver())
                .fillSubscribe()
                .getAlertSuccessSubscribe()
                .getText();
        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");
    }

}
