package AlertPopUpHandling;

import Tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertHandlingPractice extends TestBase {
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlert.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        WebElement resultMessage=driver.findElement(By.xpath("//p[@id='result']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(resultMessage.isDisplayed());
        softAssert.assertAll();

    }
    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlertConfirm=driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsAlertConfirm.click();
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement resultMessage=driver.findElement(By.xpath("//p[@id='result']"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resultMessage.getText(),"You clicked: Cancel");
        jsAlertConfirm.click();
        alert.accept();
        softAssert.assertEquals(resultMessage.getText(),"You clicked: Ok");
        softAssert.assertAll();
    }
    @Test
    public void test3(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert=driver.switchTo().alert();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(alert.getText(),"I am a JS prompt");
        alert.sendKeys("Test3");
        alert.accept();
        WebElement resultMessage=driver.findElement(By.xpath("//p[@id='result']"));
        softAssert.assertEquals(resultMessage.getText(),"You entered: Test3");
        softAssert.assertAll();



    }
}
