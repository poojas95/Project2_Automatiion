package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import pages.HomePage;

public class TestCase25 extends TestBasic {

	 public void verifyScrollUpUsingArrowButtonAndScrollDownFunctionality() throws InterruptedException {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifySubscriptionIsVisible();
	        verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen();
	    }

	    @Step("Verify 'SUBSCRIPTION' is visible")
	    public static void verifySubscriptionIsVisible() {
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        js.executeScript("arguments[0].scrollIntoView();", new HomePage(getDriver()).getSubscription());
	        boolean subscriptionIsDisplayed = new HomePage(getDriver()).getSubscription().isDisplayed();
	        Assert.assertTrue(subscriptionIsDisplayed, "Verify 'SUBSCRIPTION' is visible");
	    }

	    @Step("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen")
	    private void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() throws InterruptedException {
	        Thread.sleep(1000);
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        boolean fullFledgedTextIsDisplayed = new HomePage(getDriver())
	                .scrollUpButtonClick()
	                .getFullFledgedPracticeWebsiteForAutomationEngineers()
	                .isDisplayed();
	        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
	        double value = (double) js.executeScript("return window.pageYOffset;");
	        Assert.assertTrue(value < 2500, "Verify that page is scrolled up");
	        System.out.println(value);
	    }
}
