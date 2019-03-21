package example.steps;

import example.pages.BlazeDemo_LoginSuccess;
import io.qameta.allure.Step;
import org.junit.Assert;

public class BlazeDemo_LoginSuccessSteps {

    private BlazeDemo_LoginSuccess loginSuccessPage;

    public BlazeDemo_LoginSuccessSteps(){loginSuccessPage = new BlazeDemo_LoginSuccess();}

    @Step("Validate Successful Login")
    public void validateSuccessfulLogin() {
        Assert.assertTrue(loginSuccessPage.isDisplayed(loginSuccessPage.getLoginSuccessPageMap(BlazeDemo_LoginSuccess.claves.successMessage)));
        Assert.assertEquals( "You are logged in!",loginSuccessPage.getSuccessMessage().getText());
    }
}
