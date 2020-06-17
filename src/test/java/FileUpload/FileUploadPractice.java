package FileUpload;

import Tests.TestBase;
import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FileUploadPractice extends TestBase {
    @Test
    public void chooseFileTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.xpath("//input[@id='file-upload']"));
        chooseFile.sendKeys("C:\\Users\\Administrator.DESKTOP-DMM2MC9\\Pictures\\computer-icons-anonymous-avatar-clip-art-anonymous.jpg");
        WebElement uploadButton=driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadButton.click();
        String actualHeader=driver.findElement(By.xpath("//h3")).getText();
        String expectedHeader="File Uploaded!";
        softAssert.assertEquals(actualHeader,expectedHeader);
        String actualFile=driver.findElement(By.xpath("//div[@class='panel text-center']")).getText();
        String expectedFile="computer-icons-anonymous-avatar-clip-art-anonymous.jpg";
        softAssert.assertEquals(actualFile,expectedFile);
        softAssert.assertAll();


    }
    @Test
    public void FileUploadTest2(){
        driver.get("http://demo.guru99.com/test/upload/");
        driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\Administrator.DESKTOP-DMM2MC9\\Downloads\\TechtorialAcademy.png");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.name("send")).click();
        String expectedMessage="1 file\n" +
                "has been successfully uploaded.";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3//center")));
        String actualMessage=driver.findElement(By.xpath("//h3//center")).getText();
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();

    }
}
