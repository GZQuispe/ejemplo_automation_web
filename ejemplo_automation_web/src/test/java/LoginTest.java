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

        Assert.assertTrue(homePage.isDisplayed(homePage.getHomePageMap(BlazeDemo_HomePage.claves.homeMessage)));
        Assert.assertEquals(homePage.getHomeMessage(), "Welcome to the Simple Travel Agency!");

        Assert.assertTrue(homePage.isDisplayed(homePage.getHomePageMap(BlazeDemo_HomePage.claves.homeButton)));
        homePage.getHomeButton().click();

        /*****************LOGIN-PAGE****************/

        BlazeDemo_Login loginPage = new BlazeDemo_Login();

        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.loginAnchor)));
        Assert.assertEquals(loginPage.getLoginAnchor().getText(), "Login");
        loginPage.clickRegisterButton();

        /**************REGISTER-PAGE*************/

        BlazeDemo_Register registerPage = new BlazeDemo_Register();

        Assert.assertTrue(registerPage.isDisplayed(registerPage.getRegisterPageMap(BlazeDemo_Register.claves.registerAnchor)));
        Assert.assertEquals(registerPage.getRegisterAnchor(),"Register");
        registerPage.registerToBlazeDemo("Usuario", "compania", "usuario@server.com", "123123", "123123");
        registerPage.clickRegisterButton();

        /*****************BACK-TO-LOGIN-PAGE**************/

        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.loginAnchor)));
        Assert.assertEquals(loginPage.getLoginAnchor().getText(), "Login");
        loginPage.loginToBlazeDemo("usuario@server.com","123123");
        loginPage.clickLoginButton();

        /******************LOGIN-SUCCESS-PAGE*******************/

        BlazeDemo_LoginSuccess loginSuccessPage = new BlazeDemo_LoginSuccess();

        Assert.assertTrue(loginSuccessPage.isDisplayed(loginSuccessPage.getLoginSuccessPageMap(BlazeDemo_LoginSuccess.claves.successMessage)));
        Assert.assertEquals(loginSuccessPage.getSuccessMessage().getText(), "You are logged in!");
    }
}