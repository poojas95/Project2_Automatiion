package tests;

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'Login to your account' is visible
//6. Enter correct email address and password
//7. Click 'login' button
//8. Verify that 'Logged in as username' is visible
//9. Click 'Delete Account' button
//10. Verify that 'ACCOUNT DELETED!' is visible
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.JSONReader;
import pages.LoginSignupPage;

import java.io.IOException;
import java.text.ParseException;


public class TestCase2 extends TestBasic {

    
    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        verifyLoginToYourAccountIsVisible();
        verifyThatLoggedInAsUsernameIsVisible();
    }

    @Step("Verify 'Login to your account' is visible")
    public static void verifyLoginToYourAccountIsVisible() {
        String loginToYourAccountText = new HomePage(getDriver())
                .signupLoginClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
    }

    @Step("Verify that 'Logged in as username' is visible")
    private static void verifyThatLoggedInAsUsernameIsVisible() throws IOException, ParseException {
        String username = new LoginSignupPage(getDriver())
                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"))
                .getUsername()
                .getText();
        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify that 'Logged in as username' is visible");
    }
}
