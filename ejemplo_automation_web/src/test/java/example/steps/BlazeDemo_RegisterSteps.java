package example.steps;

import example.pages.BlazeDemo_Register;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_RegisterSteps {

    private BlazeDemo_Register registerPage;

    public BlazeDemo_RegisterSteps(){
        registerPage = new BlazeDemo_Register();
    }

    @Step("Validate Register Input")
    public void validateRegisterInput() {
        registerPage.registerToBlazeDemo("Usuario", "compania", "usuario@server.com", "123123", "123123");
    }

    @Step("Validate Register Button")
    public void clickRegisterButton() {
        Assert.assertTrue(registerPage.isDisplayed(registerPage.getRegisterPageMap(BlazeDemo_Register.claves.registerButton)));
        registerPage.getRegisterButton().click();
    }

    @Step("Validate Register Message")
    public void validateRegisterMessage() {
        Assert.assertTrue(registerPage.isDisplayed(registerPage.getRegisterPageMap(BlazeDemo_Register.claves.registerAnchor)));
        Assert.assertEquals("Register",registerPage.getRegisterAnchor());
    }
}
