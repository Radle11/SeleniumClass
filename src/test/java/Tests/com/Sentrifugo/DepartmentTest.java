package Tests.com.Sentrifugo;

import Pages.Sentrifugo.Departments;
import Pages.Sentrifugo.LogInPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepartmentTest extends TestBase {
    Departments dep;
    LogInPage li;
    @BeforeClass
    public void setUpPage(){
        dep=new Departments(driver);
        li=new LogInPage(driver);
    }
    @Test
    public void test1(){
        driver.get("http://demo.sentrifugo.com/index.php/");
        li.login("EM01","sentrifugo");
        dep.departmentButton.click();
        dep.addNewButton.click();
        dep.departmentName.sendKeys("Finance");
        dep.departmentCode.sendKeys("FN");
        dep.timeZone.click();
        dep.detroitTime.click();
        dep.saveButton.click();
        Assert.assertTrue(dep.successMessage.isDisplayed());
        


    }
}
