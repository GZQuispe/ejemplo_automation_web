import example.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Test.BaseTest;

import java.util.logging.Logger;

public class LoginTest extends BaseTest {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LoginTest.class));

    @Before
    public void open() {
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Register and login successfully test")
    public void testRegisterAndLogin_OK() {



        /*******************HOME-PAGE*******************/

        BlazeDemo_HomePage homePage = new BlazeDemo_HomePage();

        validateHomeMessage(homePage);
        validateHomeButton(homePage);

        /*****************LOGIN-PAGE****************/

        BlazeDemo_Login loginPage = new BlazeDemo_Login();

        validateLoginMessage(loginPage);

        validateLoginRegisterButton(loginPage);

        /**************REGISTER-PAGE*************/

        BlazeDemo_Register registerPage = new BlazeDemo_Register();

        validateRegisterMessage(registerPage);
        validateRegisterInput(registerPage);
        validateRegisterButton(registerPage);

        /*****************BACK-TO-LOGIN-PAGE**************/

        validateLoginMessage(loginPage);
        validateLoginInput(loginPage);
        validateLoginButton(loginPage);

        /******************LOGIN-SUCCESS-PAGE*******************/

        BlazeDemo_LoginSuccess loginSuccessPage = new BlazeDemo_LoginSuccess();

        validateSuccessfulLogin(loginSuccessPage);
    }

    public void validateSuccessfulLogin(BlazeDemo_LoginSuccess loginSuccessPage) {
        Assert.assertTrue(loginSuccessPage.isDisplayed(loginSuccessPage.getLoginSuccessPageMap(BlazeDemo_LoginSuccess.claves.successMessage)));
        Assert.assertEquals(loginSuccessPage.getSuccessMessage().getText(), "You are logged in!");
    }

    public void validateLoginButton(BlazeDemo_Login loginPage) {
        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.loginButton)));
        loginPage.getLoginButton().click();
    }

    public void validateLoginInput(BlazeDemo_Login loginPage) {
        loginPage.loginToBlazeDemo("usuario@server.com","123123");
    }

    public void validateRegisterInput(BlazeDemo_Register registerPage) {
        registerPage.registerToBlazeDemo("Usuario", "compania", "usuario@server.com", "123123", "123123");
    }

    public void validateRegisterButton(BlazeDemo_Register registerPage) {
        Assert.assertTrue(registerPage.isDisplayed(registerPage.getRegisterPageMap(BlazeDemo_Register.claves.registerButton)));
        registerPage.getRegisterButton().click();
    }

    public void validateRegisterMessage(BlazeDemo_Register registerPage) {
        Assert.assertTrue(registerPage.isDisplayed(registerPage.getRegisterPageMap(BlazeDemo_Register.claves.registerAnchor)));
        Assert.assertEquals(registerPage.getRegisterAnchor(),"Register");
    }

    public void validateLoginRegisterButton(BlazeDemo_Login loginPage) {
        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.registerButton)));
        loginPage.getRegisterButton().click();
    }

    public void validateLoginMessage(BlazeDemo_Login loginPage) {
        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.loginAnchor)));
        Assert.assertEquals(loginPage.getLoginAnchor().getText(), "Login");
    }

    public void validateHomeButton(BlazeDemo_HomePage homePage) {
        Assert.assertTrue(homePage.isDisplayed(homePage.getHomePageMap(BlazeDemo_HomePage.claves.homeButton)));
        homePage.getHomeButton().click();
    }

    public void validateHomeMessage(BlazeDemo_HomePage homePage) {
        Assert.assertTrue(homePage.isDisplayed(homePage.getHomePageMap(BlazeDemo_HomePage.claves.homeMessage)));
        Assert.assertEquals(homePage.getHomeMessage(), "Welcome to the Simple Travel Agency!");
    }
}