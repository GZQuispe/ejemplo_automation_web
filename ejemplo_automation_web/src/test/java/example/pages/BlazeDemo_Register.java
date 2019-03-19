package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class BlazeDemo_Register extends WebComponent {

    private HashMap<claves, By> loginPageMap = new HashMap();

    public enum claves {
        nameField("nameField"),
        companyField("emailField"),
        emailField("emailField"),
        passwordField("passwordField"),
        confirmPasswordField("confirmPasswordField"),
        registerButton("registerButton"),
        registerAnchor("registerAnchor");

        private String clave;

        claves(String clave) {
            this.clave = clave;
        }
    }

    public BlazeDemo_Register()
    {
        loginPageMap.put(claves.nameField, nameField);
        loginPageMap.put(claves.companyField, companyField);
        loginPageMap.put(claves.emailField, emailField);
        loginPageMap.put(claves.passwordField, passwordField);
        loginPageMap.put(claves.confirmPasswordField, confirmPasswordField);
        loginPageMap.put(claves.registerButton, registerButton);
        loginPageMap.put(claves.registerAnchor, registerAnchor);
    }

    public By getRegisterPageMap(claves clave) {
        return loginPageMap.get(clave);
    }

    By nameField = By.id("name");
    By companyField = By.id("company");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("password-confirm");
    By registerButton = By.xpath("//button[text()[contains(.,'Register')]]");
    public By registerAnchor = By.xpath("//div[@class='panel-heading']");

    public void setName(String name)
    {
        getDriver().findElement(nameField).sendKeys(name);
    }
    public void setEmailField(String email)
    {
        getDriver().findElement(emailField).sendKeys(email);
    }
    public void setCompanyField(String company)
    {
        getDriver().findElement(companyField).sendKeys(company);
    }
    public void setPasswordField(String password)
    {
        getDriver().findElement(passwordField).sendKeys(password);
    }
    public void setConfirmPasswordField(String confirmPassword)
    {
        getDriver().findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void registerToBlazeDemo(String name,String company,String email,String password, String confirmPassword){
        setName(name);
        setCompanyField(company);
        setEmailField(email);
        setPasswordField(password);
        setConfirmPasswordField(confirmPassword);
    }

    public WebElement getRegisterButton()
    {
        return getDriver().findElement(registerButton);
    }

    public String getRegisterAnchor()
    {
        return getDriver().findElement(registerAnchor).getText();
    }
}
