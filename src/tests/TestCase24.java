package tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import pages.PaymentPage;
import pages.Util;
import pages.VerifyDownload;

public class TestCase24 extends TestBasic{

	String name = "name" + Util.generateCurrentDateAndTime();
    String email = "email" + Util.generateCurrentDateAndTime() + "@o2.pl";
    
	public void downloadInvoiceAfterPurchaseOrder() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase14.verifyThatCartPageIsDisplayed();
        TestCase14.verifyAccountCreatedAndClickContinueButton(name, email);
        TestCase14.verifyLoggedInAsUsernameAtTop(name);
        TestCase14.verifyAddressDetailsAndReviewYourOrder();
        TestCase14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
        clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully();
        new PaymentPage(getDriver()).continueButtonClick();
        TestCase1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
    }

    @Step("Click 'Download Invoice' button and verify invoice is downloaded successfully")
    private void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() throws IOException {
        new PaymentPage(getDriver()).downloadInvoiceButtonClick();
        boolean isFileDownloaded = VerifyDownload.isFileDownloaded("invoice", "txt", 5000);
        Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");
    }
}
