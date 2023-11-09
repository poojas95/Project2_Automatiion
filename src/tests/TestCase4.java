package tests;
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter correct email address and password
//7. Click 'login' button
//8. Verify that 'Logged in as username' is visible
//9. Click 'Logout' button
//10. Verify that user is navigated to login page
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import pages.LoggedHomePage;


public class TestCase4 extends TestBasic {
	
	    public void logoutUser() throws IOException, ParseException {
	        TestCase2.loginUserWithCorrectEmailAndPassword();
	        verifyThatUserIsNavigatedToLoginPage();
	    }

	    @Step("Verify that user is navigated to login page")
	    private void verifyThatUserIsNavigatedToLoginPage() {
	        String loginToYourAccountText = new LoggedHomePage(getDriver())
	                .logoutButtonClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
	    }

}
