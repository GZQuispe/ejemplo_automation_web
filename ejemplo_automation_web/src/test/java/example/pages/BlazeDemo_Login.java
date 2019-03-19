package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


public class BlazeDemo_Login extends WebComponent {

    private HashMap<claves, By> loginPageMap = new HashMap();

    public enum claves {
        registerButton("registerButton"),
        emailField("emailField"),
        passwordField("passwordField"),
        loginAnchor("loginAnchor"),
        loginButton("loginButton");

        private String clave;

        claves(String clave) {
            this.clave = clave;
        }
    }

    By registerButton = By.xpath("//*[contains(text(),'Register')]");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");
    By loginAnchor = By.xpath("//div[@class = 'panel-heading']");

    public BlazeDemo_Login()
    {
        loginPageMap.put(claves.registerButton, registerButton);
        loginPageMap.put(claves.emailField, emailField);
        loginPageMap.put(claves.passwordField, passwordField);
        loginPageMap.put(claves.loginAnchor, loginAnchor);
        loginPageMap.put(claves.loginButton, loginButton);
    }

    public By getLoginPageMap(claves clave) {
        return loginPageMap.get(clave);
    }

    public WebElement getRegisterButton()
    {
        return getDriver().findElement(registerButton);
    }

    private void setEmail(String email)
    {
        getDriver().findElement(emailField).sendKeys(email);
    }

    private void setPassword(String password)
    {
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public WebElement getLoginButton()
    {
        return getDriver().findElement(loginButton);
    }

    public WebElement getLoginAnchor (){
        return getDriver().findElement(loginAnchor);
    }

    public void loginToBlazeDemo(String email, String password)
    {
        this.setEmail(email);
        this.setPassword(password);
    }
}
