package tests;

import java.io.IOException;
import java.text.ParseException;

import pages.Util;

public class TestCase23 extends TestBasic{

	String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";
    
    public void verifyAddressDetailsInCheckoutPage() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
        TestCase14.verifyLoggedInAsUsernameAtTop(name);
        TestCase14.verifyThatCartPageIsDisplayed();
        verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount();
        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    @Step("Verify that the delivery address and the billing address is same address filled at the time registration of account")
    private void verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() throws IOException, ParseException {
        TestCase14.verifyAddressDetails();
    }
}
