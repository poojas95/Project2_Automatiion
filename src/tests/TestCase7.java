package tests;
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Test Cases' button
//5. Verify user is navigated to test cases page successfully

import org.testng.Assert;

import pages.HomePage;

public class TestCase7 extends TestBasic{

	 public void verifyTestCasesPage() {
	        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToTestCasesPageSuccessfully();
	    }

	    @Step("Verify user is navigated to test cases page successfully")
	    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
	        String testCasesText = new HomePage(getDriver())
	                .testCasesButtonClick()
	                .getTestCases()
	                .getText();
	        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");

	    }
}