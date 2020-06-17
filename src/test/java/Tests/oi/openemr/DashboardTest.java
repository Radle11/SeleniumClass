package Tests.oi.openemr;

import Pages.openemr.Dashboard;
import Pages.openemr.HomePage;
import Pages.openemr.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;

public class DashboardTest extends TestBase {
    LoginPage logInPage;
    HomePage homePage;
    Dashboard dashboard;
    WebDriverWait wait;
    Actions actions;
    @BeforeClass
    public void setUpHomePage(){
        homePage=new HomePage(driver);
        dashboard=new Dashboard(driver);
        logInPage=new LoginPage(driver);
       actions=new Actions(driver);
       wait=new WebDriverWait(driver,5);

    }
    @Test
    public void test1(){
        driver.navigate().to("https://demo.openemr.io/openemr");
        logInPage.login("admin","pass");
        //HomePage class
        homePage.search.sendKeys("Phil", Keys.ENTER);
        driver.switchTo().frame(homePage.iFrame);
        wait.until(ExpectedConditions.visibilityOf(homePage.philBelford));
        String nameHP=homePage.philBelford.getText();
        String phoneNumberHP=homePage.phoneNumber.getText();
        String ssnHP=homePage.ssn.getText();
        String dobHP=homePage.birthDate.getText();
        String externalIdHP=homePage.externalId.getText();
        homePage.philBelford.click();
        //Dashboard class
        driver.switchTo().defaultContent();
        driver.switchTo().frame(dashboard.iFrame);
        wait.until(ExpectedConditions.visibilityOf(dashboard.dashboardName));
        String nameDB=dashboard.dashboardName.getText();
        String ssnDB=dashboard.dashboardSSN.getText();
        String dobDB=dashboard.dashboardDOB.getText();
        String externalIdDB=dashboard.dashboardExternalID.getText();
        //patients expected info
        String expectedNameHP="Belford, Phil";
        String expectedNameDB=" Phil  Belford";
        String expectedPhoneNumb="333-444-2222";
        String expectedSSN="333222333";
        String expectedDOB="1972-02-09";
        String expectedID="1";
        //#1
        Assert.assertTrue(nameDB.equals(expectedNameDB)&&nameHP.equals(expectedNameHP),
                "test1 #1 Test failed.\nExpected: "+expectedNameDB+" or "+expectedNameHP+"\nHome Page Actual: "+nameHP+
                "\nDashboard Actual: "+nameDB);
        //#2
        Assert.assertTrue(ssnDB.equals(expectedSSN)&&ssnHP.equals(expectedSSN),
                "test1 #2 Test failed.\nExpected: "+expectedSSN+"\nHome Page Actual: "+ssnHP+
                        "\nDashboard Actual: "+ssnDB);
        //#3
        Assert.assertEquals(phoneNumberHP,expectedPhoneNumb,"test1 #3 Test failed. \nExpected: "
                +expectedPhoneNumb+"\nActual: "+phoneNumberHP);
        //#4
        Assert.assertTrue(dobDB.equals(expectedDOB)&&dobHP.equals(expectedDOB),
                "test1 #4 Test failed.\nExpected: "+expectedDOB+"\nHome Page Actual: "+dobHP+
                        "\nDashboard Actual: "+dobDB);
        //#5
        Assert.assertTrue(externalIdDB.equals(expectedID)&&externalIdHP.equals(expectedID),
                "test1 #5 Test failed.\nExpected: "+expectedID+"\nHome Page Actual: "+externalIdHP+
                        "\nDashboard Actual: "+externalIdDB);
        //#6
        driver.switchTo().defaultContent();
        Assert.assertTrue(dashboard.age.isDisplayed(),"test1 #6 Test is Failed");
        //#7
        String ageStr=dashboard.age.getText().substring(dashboard.age.getText().lastIndexOf(" ")+1);
        int actualAge=Integer.parseInt(ageStr);
        String birthYear=dashboard.age.getText().substring(dashboard.age.getText().indexOf(" ")+1,
                dashboard.age.getText().indexOf("-"));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYearInt=Integer.parseInt(birthYear);
        int expectedAge=currentYear-birthYearInt;
        Assert.assertEquals(actualAge,expectedAge,"test1 #7 Test Failed.");

    }

    @AfterClass
    public void quitWindow(){
        driver.quit();
    }
}
