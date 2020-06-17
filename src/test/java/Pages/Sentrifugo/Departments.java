package Pages.Sentrifugo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Departments {
    public Departments(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//img[@src='http://demo.sentrifugo.com/public/media/images/menuIcons/shortcuts/department-icon.jpg']")
    public WebElement departmentButton;
    @FindBy(xpath = "//input[@title='Add']")
    public WebElement addNewButton;
    @FindBy(name = "deptname")
    public WebElement departmentName;
    @FindBy(id = "deptcode")
    public WebElement departmentCode;
    @FindBy(id="s2id_timezone")
    public WebElement timeZone;
    @FindBy(xpath = "//span[.='America/Detroit [EDT]']")
    public  WebElement detroitTime;
    @FindBy(id = "submitbutton")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='style-1-icon success']")
    public WebElement successMessage;

}
