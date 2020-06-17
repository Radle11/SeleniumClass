package Tests.com.Sentrifugo;

import Pages.Sentrifugo.LogInPage;
import Pages.Sentrifugo.MeritalStatusPage;
import Tests.TestBase;
import Tests.com.Sentrifugo.TestData.MaritalStatusData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MeritalStatusTest extends TestBase {
    LogInPage logInPage;
    MeritalStatusPage meritalStatusPage;
    @BeforeClass
    public void setMaritalStatusPage(){
        logInPage=new LogInPage(driver);
        meritalStatusPage=new MeritalStatusPage(driver);
    }

   // @Parameters({"maritalCode","maritalStatus","description"})
    @Test(dataProvider = "maritalInfo",dataProviderClass = MaritalStatusData.class)
    public void test1(String maritalCode, String maritalStatus,String description){
        meritalStatusPage.meritalCode.sendKeys(maritalCode);
        meritalStatusPage.meritalStatus.sendKeys(maritalStatus);
        meritalStatusPage.description.sendKeys(description);
        meritalStatusPage.submitButton.click();
        Assert.assertTrue(meritalStatusPage.successMessage.isDisplayed());
        meritalStatusPage.addButton.click();

    }
    @Parameters({"username","password"})
    @Test
    public void testA2(String username, String password){
        driver.navigate().to("http://demo.sentrifugo.com/index.php/");
        logInPage.login(username,password);
        meritalStatusPage.gender.click();
        meritalStatusPage.addButton.click();
        meritalStatusPage.submitButton.click();
        String actualMaritalCodeError=meritalStatusPage.errorMeritalCode.getText();
        String actualMaritalStatusError=meritalStatusPage.errorMeritalStatus.getText();
        String expectedMaritalCodeError="Please enter marital code.";
        String expectedMaritalStatusError="Please enter marital status.";
       // hard Assertion
        Assert.assertEquals(actualMaritalCodeError,expectedMaritalCodeError);
        Assert.assertEquals(actualMaritalStatusError,expectedMaritalStatusError);
        

    }
}
