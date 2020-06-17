package Pages.Sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage(WebDriver driver){
        //it will help us to initialize our web elements
        PageFactory.initElements(driver,this);//this keyword refers to current page(class)
        //without it NoSuchElement exception will be thrown

    }
    //@FindBy(locator)
    //id, tagname, css selector, linkText, partialLinkText, className,xpath
    @FindBy(id="username")
    public WebElement username;
    @FindBy(id="password")
    public WebElement password;
    @FindBy(xpath = "//input[@id='loginsubmit']")
    public WebElement loginButton;

public void login(String username, String password){
    this.username.sendKeys(username);
    this.password.sendKeys(password);
    this.loginButton.click();
}



}
