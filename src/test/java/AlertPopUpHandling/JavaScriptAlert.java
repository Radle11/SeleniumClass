package AlertPopUpHandling;

import Tests.TestBase;
import Utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptAlert extends TestBase {

    @Test
    public void sweetAlert(){
        driver.get("https://sweetalert.js.org/");
        WebElement previewButton1=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        previewButton1.click();
        String actualMessage=driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
        String expectedMessge="Something went wrong!";
        Assert.assertEquals(actualMessage,expectedMessge);
        driver.findElement(By.xpath("//button[.='OK']")).click();
    }
    @Test
    public void javaScriptAlert() throws InterruptedException {
        driver.get("https://sweetalert.js.org/");
        WebElement previewButton2=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
        previewButton2.click();
        Thread.sleep(500);
        Alert alert=driver.switchTo().alert();
        String actualAlertMessage=alert.getText();
        String expectedAlertMessage="Oops, something went wrong!";
        Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
        alert.accept();

    }
}
