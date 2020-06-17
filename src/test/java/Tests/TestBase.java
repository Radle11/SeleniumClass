package Tests;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestBase {
   public WebDriver driver=null;
   public  SoftAssert softAssert;
   public WebDriverWait wait;
   @Parameters("driverName")
   @BeforeClass(alwaysRun = true)
    public void setUp(String driverName){
       driver= Driver.getDriver(driverName);
       driver.manage().window().maximize();
       softAssert=new SoftAssert();
       wait=new WebDriverWait(driver,3);
   }
}
