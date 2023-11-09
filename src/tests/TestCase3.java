package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import okhttp3.internal.Util;
import pages.LoginSignupPage;

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter incorrect email address and password
//7. Click 'login' button
//8. Verify error 'Your email or password is incorrect!' is visible

public class TestCase3 extends TestBasic {

  
    public void loginUserWithIncorrectEmailAndPassword() {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase2.verifyLoginToYourAccountIsVisible();
        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
    }

    @Step("Verify error 'Your email or password is incorrect!' is visible")
    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
        String email = "email" + pages.Util.generateCurrentDateAndTime() + "@incorrect.pl";
    	
        String password = "pass" + pages.Util.generateCurrentDateAndTime();

        String errorLoginText = new LoginSignupPage(getDriver())
                .fillIncorrectLogin(email, password)
                .getErrorLogin()
                .getText();
        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
    }
}