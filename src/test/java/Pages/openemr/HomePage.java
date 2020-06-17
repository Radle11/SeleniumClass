package Pages.openemr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//iframe[@name='fin']")
    public WebElement iFrame;
    @FindBy(xpath = "//input[@id='anySearchBox']")
    public WebElement search;
    @FindBy(xpath = "//tr//td[.='Belford, Phil']")
    public WebElement philBelford;
    @FindBy(xpath = "//tr//td[.='333-444-2222']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//tr//td[.='333222333']")
    public WebElement ssn;
    @FindBy(xpath = "//tr//td[.='1972-02-09']")
    public WebElement birthDate;
    @FindBy(xpath = "//tr//td[.='Belford, Phil']//following-sibling::td[.='1']")
    public WebElement externalId;


}
