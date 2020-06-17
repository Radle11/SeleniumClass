package Tests.oi.openemr;

import Pages.openemr.*;
import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class AmendmentsTest extends TestBase {
    Dashboard dashboard;
    HomePage homePage;
    LoginPage loginPage;
    Messages messages;
    Amendments amendments;
    WebDriverWait wait;
    Actions actions;
    @BeforeClass
    public void setAmendments(){
        dashboard=new Dashboard(driver);
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
        messages=new Messages(driver);
        amendments=new Amendments(driver);
        wait=new WebDriverWait(driver,5);
        actions =new Actions(driver);
    }
    @Test
    public void test3(){
        driver.navigate().to("https://demo.openemr.io/openemr");
        loginPage.login("admin","pass");
        homePage.search.sendKeys("Phil", Keys.ENTER);
        driver.switchTo().frame(homePage.iFrame);
        wait.until(ExpectedConditions.visibilityOf(homePage.philBelford));
        homePage.philBelford.click();
       driver.switchTo().defaultContent();
       driver.switchTo().frame(dashboard.iFrame);
       wait.until(ExpectedConditions.visibilityOf(dashboard.amendments));
        //#1
        String actualAmendment=dashboard.amendments.getText()+" ("+dashboard.expand.getText()+")";
        String expectedAmendmentExpand="Amendments (expand)";
        Assert.assertEquals(actualAmendment,expectedAmendmentExpand,"test3 #1 Test Failed.");
       //#2
        dashboard.amendments.click();
        actualAmendment=dashboard.amendments.getText()+" ("+dashboard.expand.getText()+")";
        String expectedAmendmentCollapse="Amendments (collapse)";
        Assert.assertTrue(actualAmendment.equals(expectedAmendmentCollapse),
                "test3 #2 Test Failed. \nActual: "+actualAmendment+"\nExpected: "+expectedAmendmentCollapse);
        //#3
        amendments.editButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(amendments.iFrame);
        Assert.assertTrue(amendments.message.isDisplayed(),"test3 #3 Test Failed");
        //#4
        String redCSS=amendments.message.getCssValue("style");//gives css value
        Assert.assertTrue(redCSS.contains("rgb(255, 0, 0)"),"test3 #4 Test Failed.");
        //#5
        driver.switchTo().defaultContent();
        amendments.addButton.click();
        actions.moveToElement(amendments.datePick).click().build().perform();
        actions.click(amendments.targetMonth).moveToElement(amendments.may).click().perform();
        actions.moveToElement(amendments.targetDate).click();
        Select select=new Select(amendments.requestedBy);
        select.selectByVisibleText("Insurance");
        amendments.textarea.sendKeys("insurance amendment for test");
        select=new Select(amendments.status);
        select.selectByVisibleText("Rejected");
        amendments.comment.sendKeys("new amendment created");
        amendments.saveButton.click();
        LocalDate localDate=LocalDate.now();
        String expectedDate=""+localDate;
        String actualDate=amendments.currentDate.getText();
        Assert.assertEquals(actualDate,expectedDate,"test3 #5 Test Failed.");
        //#6
        String actualBy=amendments.billySmith.getText();
        String expectedBy="Smith, Billy";
        Assert.assertEquals(actualBy,expectedBy,"test3 #6 Test Failed.");
        //#7
        String actualStatusResult=amendments.statusResult.getText();
        String expectedStatusResult="Rejected";
        Assert.assertEquals(actualStatusResult,expectedStatusResult,"test3 #7 Test Failed.");
        //#8
        String actualComment=amendments.getComment.getText();
        String expectedComment="new amendment created";
        Assert.assertEquals(actualComment,expectedStatusResult,"test3 #8 Test Failed.");
        //#9
        driver.switchTo().parentFrame();
        amendments.listButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(amendments.iFrame);
        Assert.assertTrue(amendments.newAmendment.isDisplayed(),"test3 #9 Test Failed");
    }
}
