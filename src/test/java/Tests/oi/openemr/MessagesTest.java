package Tests.oi.openemr;

import Pages.openemr.Dashboard;
import Pages.openemr.HomePage;
import Pages.openemr.LoginPage;
import Pages.openemr.Messages;
import Tests.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MessagesTest extends TestBase {
    HomePage homePage;
    LoginPage logInPage;
    Dashboard dashboard;
    Messages messages;
    WebDriverWait wait;
    Actions actions;

    @BeforeClass
    public void setMessages(){
        logInPage=new LoginPage(driver);
        homePage=new HomePage(driver);
        dashboard=new Dashboard(driver);
        messages=new Messages(driver);
        actions=new Actions(driver);
        wait=new WebDriverWait(driver,5);
    }
    @Test
    public void test2(){
        driver.navigate().to("https://demo.openemr.io/openemr");
        logInPage.login("admin","pass");
        homePage.search.sendKeys("Phil", Keys.ENTER);
        driver.switchTo().frame(homePage.iFrame);
        wait.until(ExpectedConditions.visibilityOf(homePage.philBelford));
        homePage.philBelford.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(dashboard.iFrame);
        wait.until(ExpectedConditions.visibilityOf(dashboard.editMessage));
        dashboard.editMessage.click();
        messages.addButton.click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(messages.iFrame);
        Select select=new Select(messages.type);
        select.selectByVisibleText("Lab Results");
        new Select(messages.to).selectByVisibleText("Stone, Fred");
        messages.textarea.sendKeys("This is for testing");
        messages.saveButton.click();
        //#1 Validate new message displayed
        driver.switchTo().defaultContent();
        driver.switchTo().frame(messages.inboxFrame);
        Assert.assertTrue(messages.messageStatus.isDisplayed(),
                "test2 #1 Test failed.");
        //#2 Validate active box is selected
        Assert.assertTrue(messages.activeCheckBox.isSelected(),"test2 #2 Test Failed.");
        //#3 Validate Type is "Lab Results"
        String actualType=messages.typeInbox.getText();
        String expectedType="Lab Results";
        Assert.assertEquals(actualType,expectedType,"test2 #3 Test Failed.");
        //#4 Validate Content has today's date
        String actualContent=messages.content.getText();
        LocalDate localDate = LocalDate.now();
        String expectedDate=""+localDate;
        System.out.println(localDate);
        //website was programmed to use different time zone. Hence, close to the midnight there is date difference
        //if test case requirements will provide the time zone ID, code will be more precise by defining .now(zoneId);
        Assert.assertTrue(actualContent.startsWith(expectedDate)," test2 #4 Test Failed.");
        //#5 Validate status is "New"
        String actualStatus=messages.messageStatus.getText();
        String expectedStatus="New";
        Assert.assertEquals(actualStatus,expectedStatus,"test2 #5 Test Failed.");
        //#6 Validate Updated By is equals to Billy Smith
        String actualUpdateBy=messages.updatedBy.getText();
        String expectedUpdateBy="Billy Smith";
        Assert.assertEquals(actualUpdateBy.trim(),expectedUpdateBy,"test2 #6 Test Failed.");

    }
    @AfterClass
    public void quitWindow(){
        driver.quit();
    }
}
