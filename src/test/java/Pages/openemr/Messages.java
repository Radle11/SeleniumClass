package Pages.openemr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Messages {
    public Messages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@href='pnotes_full_add.php?docid=0&orderid=0']//span")
    public WebElement addButton;
    @FindBy(xpath = "//iframe[@id='modalframe']")
    public WebElement iFrame;
    @FindBy(xpath = "//select[@id='form_note_type']")
    public WebElement type;
    @FindBy(xpath = "//select[@name='assigned_to']")
    public WebElement to;
    @FindBy(xpath = "//textarea[@id='note' and @rows='4']")
    public WebElement textarea;
    @FindBy(xpath = "//a[@class='css_button' and @id='newnote']//span")
    public WebElement saveButton;
    @FindBy(xpath = "(//tr[@class='noterow']//td)[6]")
    public WebElement messageStatus;
    @FindBy(xpath = "(//tr//td[@class='notecell' and contains(.,'(admin to clinician) This is for testing  ')])[1]")
    public WebElement content;
    @FindBy(xpath = "//input[@name='chk105']")
    public WebElement activeCheckBox;
    @FindBy(xpath = "//iframe[@name='pat']")
    public WebElement inboxFrame;
    @FindBy(xpath = "//a[@href='pnotes_full_add.php?docid=0&orderid=0&trigger=edit&noteid=105' and @class='note_modal']")
    public WebElement typeInbox;
    @FindBy(xpath = "//tr//td[@class='notecell' and .='Billy Smith  ']")
    public WebElement updatedBy;


}
