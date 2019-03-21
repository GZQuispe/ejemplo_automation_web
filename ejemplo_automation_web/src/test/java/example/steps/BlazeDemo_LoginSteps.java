package example.steps;

import example.pages.BlazeDemo_Login;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_LoginSteps {

    private BlazeDemo_Login loginPage;

    public BlazeDemo_LoginSteps(){loginPage = new BlazeDemo_Login();}

    public void clickLoginRegisterButton() {
        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.registerButton)));
        loginPage.getRegisterButton().click();
    }


    @Step("Validate Login Message")
    public void validateLoginMessage() {
        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.loginAnchor)));
        Assert.assertEquals( "Login",loginPage.getLoginAnchor().getText());
    }

    @Step("Validate Register Input")
    public void validateLoginInput() {
        loginPage.loginToBlazeDemo("usuario@server.com","123123");
    }

    @Step("Validate Login Button")
    public void clickLoginButton() {
        Assert.assertTrue(loginPage.isDisplayed(loginPage.getLoginPageMap(BlazeDemo_Login.claves.loginButton)));
        loginPage.getLoginButton().click();
    }
}
