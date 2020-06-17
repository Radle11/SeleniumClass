package Tests.com.Sentrifugo;

import Pages.Sentrifugo.LogInPage;
import Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {//inheriting(acquiring the properties of) TestBase class fields and behaviours using extends keyword
    //befor test annotation my object from
    LogInPage page;
    @BeforeClass
    public void pageSetUp(){
      page=new LogInPage(driver);
    }
    //all test annotations will be implemented in this class
    //more than one parameter, it should be within curly braces
    @Parameters({"username","password"})
    @Test
    public void test1(String username, String password){
    driver.get("http://demo.sentrifugo.com/index.php/");
    page.username.sendKeys(username);
    page.password.sendKeys(password);
    page.loginButton.click();
    String actualURL= driver.getCurrentUrl();
    String expectedURL="http://demo.sentrifugo.com/index.php/index/welcome";
        Assert.assertEquals(actualURL,expectedURL);
    }
}
