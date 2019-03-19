package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


public class BlazeDemo_LoginSuccess extends WebComponent {

    private HashMap<claves, By> loginPageMap = new HashMap();

    public enum claves {
        successMessage("successMessage");

        private String clave;

        claves(String clave) {
            this.clave = clave;
        }
    }

    public BlazeDemo_LoginSuccess()
    {
        loginPageMap.put(claves.successMessage, successMessage);
    }

    public By getLoginSuccessPageMap(claves clave) {
        return loginPageMap.get(clave);
    }

    public By successMessage = By.xpath("//div[@class='panel-body'][contains(text(),'You are logged in!')]");

    public WebElement getSuccessMessage()
    {
        return getDriver().findElement(successMessage);
    }

}
