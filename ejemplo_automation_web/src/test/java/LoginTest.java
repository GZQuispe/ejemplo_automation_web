import example.pages.*;
import example.steps.BlazeDemo_HomeSteps;
import example.steps.BlazeDemo_LoginSteps;
import example.steps.BlazeDemo_LoginSuccessSteps;
import example.steps.BlazeDemo_RegisterSteps;
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

        BlazeDemo_HomeSteps homeSteps = new BlazeDemo_HomeSteps();

        homeSteps.validateHomeMessage();
        homeSteps.clickHomeButton();

        /*****************LOGIN-PAGE****************/

        BlazeDemo_LoginSteps loginSteps = new BlazeDemo_LoginSteps();

        loginSteps.validateLoginMessage();
        loginSteps.clickLoginRegisterButton();

        /**************REGISTER-PAGE*************/

        BlazeDemo_RegisterSteps registerPage = new BlazeDemo_RegisterSteps();

        registerPage.validateRegisterMessage();
        registerPage.validateRegisterInput();
        registerPage.clickRegisterButton();

        /*****************BACK-TO-LOGIN-PAGE**************/

        loginSteps.validateLoginMessage();
        loginSteps.validateLoginInput();
        loginSteps.clickLoginButton();

        /******************LOGIN-SUCCESS-PAGE*******************/

        BlazeDemo_LoginSuccessSteps loginSuccessSteps = new BlazeDemo_LoginSuccessSteps();

        loginSuccessSteps.validateSuccessfulLogin();
    }

}