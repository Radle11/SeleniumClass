package Pages.openemr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='authUser']")
    public WebElement userName;
    @FindBy(xpath = "//input[@name='clearPass']")
    public WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    public WebElement logInButton;
    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.logInButton.click();
    }


}
