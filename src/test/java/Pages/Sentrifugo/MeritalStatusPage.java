package Pages.Sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeritalStatusPage {
    public MeritalStatusPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='Gender']")
    public WebElement gender;
    @FindBy(id = "87")
    public WebElement meritalStatusButton;
    @FindBy(xpath = "//input[@title='Add']")
    public WebElement addButton;
    @FindBy(id = "meritalcode")
    public WebElement meritalCode;
    @FindBy(name = "meritalstatusname")
    public WebElement meritalStatus;
    @FindBy(id = "description")
    public WebElement description;
    @FindBy(id="submitbutton")
    public WebElement submitButton;
    @FindBy(className = "ml-alert-1-success")
    public WebElement successMessage;
    @FindBy(id = "errors-maritalcode")
    public WebElement errorMeritalCode;
    @FindBy(id = "errors-maritalstatusname")
    public WebElement errorMeritalStatus;
}

