package example.pages;

import Pages.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BlazeDemo_Login extends WebComponent {

    public enum claves {
        registerButton("homeMessage"),
        homeButton("homeButton");

        private String clave;

        claves(String clave) {
            this.clave = clave;
        }
    }

    By registerButton = By.xpath("//*[contains(text(),'Register')]");
    By emailField = By.id("email");
    By passwordField = By.id("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");
    public By loginAnchor = By.xpath("//div[@class = 'panel-heading']");

    public void clickRegisterButton()
    {
        getDriver().findElement(registerButton).click();
    }

    private void setEmail(String email)
    {
        getDriver().findElement(emailField).sendKeys(email);
    }

    private void setPassword(String password)
    {
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton()
    {
        getDriver().findElement(loginButton).click();
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
