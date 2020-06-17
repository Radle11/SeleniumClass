package Pages.openemr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    public Dashboard(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//iframe[@name='pat']")
    public WebElement iFrame;
    @FindBy(xpath = "//td[@id='text_title']")
    public WebElement dashboardName;
    @FindBy(xpath = "//td[@id='text_DOB']")
    public WebElement dashboardDOB;
    @FindBy(xpath = "//td[@id='text_ss']")
    public WebElement dashboardSSN;
    @FindBy(xpath = "//td[@id='text_pubpid']")
    public WebElement dashboardExternalID;
    @FindBy(xpath = "//span[@data-bind='text:patient().str_dob()']")
    public WebElement age;
    @FindBy(xpath = "//a[@href='pnotes_full.php?form_active=1']//span")
    public WebElement editMessage;
    @FindBy(xpath = "//a[@href='javascript:;']//span//b[.='Amendments']")
    public WebElement amendments;
    @FindBy(xpath = "(//a[@href='javascript:;']//span[@class='indicator'])[7]")
    public WebElement expand;
}
