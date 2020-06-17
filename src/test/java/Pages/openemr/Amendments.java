package Pages.openemr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amendments {
    public Amendments(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='/openemr/interface/patient_file/summary/list_amendments.php?id=1']//span")
    public WebElement editButton;
    @FindBy(xpath = "//form/span[@style='color:red']")
    public WebElement message;
    @FindBy(xpath = "//button[.='Add']")
    public WebElement addButton;
   @FindBy(id = "modalframe")
    public WebElement iFrame;
   @FindBy(xpath = "//input[@name='amendment_date']")
    public WebElement datePick;
   @FindBy(xpath = "//div[@class='xdsoft_label xdsoft_month']")
   public WebElement targetMonth;
   @FindBy(xpath = "//div[@data-value='4']")
   public WebElement may;
   @FindBy(xpath = "//td[@data-date='23']")
    public WebElement targetDate;
   @FindBy(xpath = "//select[@id='form_amendment_by']")
    public WebElement requestedBy;
   @FindBy(xpath = "//textarea[@id='desc']")
    public WebElement textarea;
   @FindBy(xpath = "//select[@id='form_amendment_status']")
    public WebElement status;
   @FindBy(xpath = "//textarea[@id='note']")
    public WebElement comment;
   @FindBy(xpath = "//span[.='Save']")
    public WebElement saveButton;
   @FindBy(xpath = "//table[@class='historytbl']//tbody//tr//td[starts-with(text(),'2020')]")
    public WebElement currentDate;
   @FindBy(xpath = "(//table[@class='historytbl']//tbody//tr//td)[2]")//table[@class='historytbl']//tbody//tr//td[contains(text(),'Smith, Billy')]
    public WebElement billySmith;
    @FindBy(xpath = "(//table[@class='historytbl']//tbody//tr//td)[3]")
    public WebElement statusResult;
    @FindBy(xpath = "(//table[@class='historytbl']//tbody//tr//td)[4]")
    public WebElement getComment;
    @FindBy(xpath = "//button[.='List']")
    public WebElement listButton;
    @FindBy(xpath = "//td[.='insurance amendment for test ']")
    public WebElement newAmendment;

}
