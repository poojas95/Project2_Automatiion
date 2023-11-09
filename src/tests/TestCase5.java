package tests;

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible
import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;

import pages.LoginSignupPage;


public class TestCase5 extends TestBasic 
{
    public void registerUserWithExistingEmail() throws IOException, ParseException {
        TestCase1.verifyThatHomePageIsVisibleSuccessfully();
        TestCase1.verifyNewUserSignupIsVisible();
        verifyErrorEmailAddressAlreadyExistIsVisible();
    }

    @Step("Verify error 'Email Address already exist!' is visible")
    private void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException, ParseException {
        String emailAddressAlreadyExistText = new LoginSignupPage(getDriver()).fillIncorrectSignup()
                .getEmailAddressAlreadyExist()
                .getText();
        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
    }

}
