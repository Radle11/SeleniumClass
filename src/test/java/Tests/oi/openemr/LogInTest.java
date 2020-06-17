package Tests.oi.openemr;

import Pages.openemr.LoginPage;
import Tests.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
LoginPage logInPage;
    @BeforeClass
    public void setUpPage(){
        logInPage=new LoginPage(driver);

    }
    @Test
    public void test1(){
    driver.navigate().to("https://demo.openemr.io/openemr");
    logInPage.userName.sendKeys("admin");
    logInPage.password.sendKeys("pass");
    logInPage.logInButton.click();
    }

}
